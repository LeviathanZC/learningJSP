package by.zercomp.application.controller;

import by.zercomp.application.model.entity.User;
import by.zercomp.application.model.service.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

public class RequestController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        processing(httpServletRequest, httpServletResponse);
    }

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        processing(httpServletRequest, httpServletResponse);
    }

    private void processing(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        Optional<User> user = ServiceFactory.getInstance().getUserService().signIn(login, password);
        if (user.isPresent()) {
            HttpSession session = request.getSession();
            session.setAttribute("userId", user.get().getId());
            session.setAttribute("userRole", user.get().getRole());
            response.sendRedirect("https://vk.com");
            System.out.println("google");
        } else {
            request.setAttribute("error", "Неверный логин или пароль.");
            request.getRequestDispatcher("/WEB-INF/pages/auth/signIn.jsp").forward(request, response);
            System.out.println("givni");
        }
        System.out.println("geere");
    }

    /*
    TODO
     Команды
     Реализации
     JspPath

     */
}
