package by.zercomp.application.controller.command.impl;

import by.zercomp.application.controller.command.ActionCommand;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LogInCommand implements ActionCommand {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("Hello", new Integer(10));
        request.getRequestDispatcher("/WEB-INF/pages/welcomePage.jsp");
    }
}
