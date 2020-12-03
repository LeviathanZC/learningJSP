package by.zercomp.application.controller.command.impl;

import by.zercomp.application.controller.AttributeKey;
import by.zercomp.application.controller.JspPath;
import by.zercomp.application.controller.command.ActionCommand;
import by.zercomp.application.controller.router.Router;
import by.zercomp.application.model.creator.UserCreator;
import by.zercomp.application.model.entity.User;
import by.zercomp.application.model.exception.ServiceException;
import by.zercomp.application.model.service.ServiceFactory;
import by.zercomp.application.model.service.UserService;
import by.zercomp.application.model.validator.UserValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static by.zercomp.application.controller.RequestParam.*;

public class SignUpCommand implements ActionCommand {
    private static final Logger log = LogManager.getLogger(SignUpCommand.class);
    private static UserService service = ServiceFactory.getInstance().getUserService();

    @Override
    public Router execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Router router = new Router(JspPath.ERROR_500);
        HttpSession session = request.getSession();
        Map<String, String> signUpData = new HashMap<>();
        try {
           signUpData = ActionCommand.getParamsFromReq(signUpData, request, LOGIN, PASSWORD, REPEAT_PW, FIRST_NAME,
                   LAST_NAME, EMAIL, BIRTH);

           if (UserValidator.getInstance().defineIncorrect(signUpData)) {
               User newUser = UserCreator.getCreator().create(signUpData.get(ID), signUpData.get(LOGIN),
                       signUpData.get(EMAIL), signUpData.get(FIRST_NAME),
                       signUpData.get(LAST_NAME), signUpData.get(BIRTH));
               service.signUp(newUser, signUpData.get(PASSWORD));
           } else {
               request.setAttribute(AttributeKey.ERRORS, signUpData);
               router = new Router(JspPath.SIGN_UP);
           }
        } catch (ServiceException e) {
            log.error(e);
        }
        return router;
    }
}
