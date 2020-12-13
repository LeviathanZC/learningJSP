package by.zercomp.application.controller;

import by.zercomp.application.controller.command.ActionCommand;
import by.zercomp.application.controller.command.ActionProvider;
import by.zercomp.application.controller.router.Router;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
        System.out.println("loading the page...");
        ActionCommand command = ActionProvider.defineAction(request.getParameter(RequestParam.COMMAND));
        Router router = command.execute(request, response);
        switch (router.getType()) {
            case FORWARD: {
                request.getRequestDispatcher(router.getPage()).forward(request, response);
                break;
            }
            case REDIRECT: {
                response.sendRedirect(router.getPage());
                break;
            }
        }
    }
}
