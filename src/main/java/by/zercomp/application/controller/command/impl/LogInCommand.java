package by.zercomp.application.controller.command.impl;

import by.zercomp.application.controller.AttributeName;
import by.zercomp.application.controller.RequestParam;
import by.zercomp.application.controller.command.ActionCommand;
import by.zercomp.application.controller.router.Router;
import by.zercomp.application.model.entity.User;
import by.zercomp.application.model.exception.ServiceException;
import by.zercomp.application.model.service.ServiceFactory;
import by.zercomp.application.model.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Locale;
import java.util.Optional;

public class LogInCommand implements ActionCommand {

    private UserService service = ServiceFactory.getInstance().getUserService();

    @Override
    public Router execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
            }
        } catch (ServiceException e) {

        }
        return ;
            request.setAttribute("error", "Неверный логин или пароль.");
            request.getRequestDispatcher("/WEB-INF/pages/auth/signIn.jsp").forward(request, response);
            System.out.println("givni");
        }
    }
}
