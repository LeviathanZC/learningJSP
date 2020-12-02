package by.zercomp.application.controller.command.impl;

import by.zercomp.application.controller.AttributeName;
import by.zercomp.application.controller.JspPath;
import by.zercomp.application.controller.RequestParam;
import by.zercomp.application.controller.command.ActionCommand;
import by.zercomp.application.controller.router.Router;
import by.zercomp.application.controller.router.RouterType;
import by.zercomp.application.model.entity.User;
import by.zercomp.application.model.exception.ServiceException;
import by.zercomp.application.model.service.ServiceFactory;
import by.zercomp.application.model.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

public class LogInCommand implements ActionCommand {

    private static final Logger log = LogManager.getLogger(LogInCommand.class);
    private UserService service = ServiceFactory.getInstance().getUserService();

    @Override
    public Router execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //TODO router page string
        Router router = new Router("", RouterType.REDIRECT);
        String login = request.getParameter(RequestParam.LOGIN);
        String password = request.getParameter(RequestParam.PASSWORD);
        HttpSession session = request.getSession();
        try {
            Optional<User> user = service.signIn(login, password);
            if (user.isPresent()) {
                session.setAttribute(AttributeName.ROLE_NAME, user.get().getRole().name().toLowerCase());
                session.setAttribute(AttributeName.LOGIN, user.get().getLogin());
            } else {
                request.setAttribute(AttributeName.ERROR, true);
                router.setForward(JspPath.SIGN_IN);
            }
        } catch (ServiceException e) {
            log.error(e);
            router.setForward(JspPath.ERROR_500);
        }
        return router;
    }
}

