package by.zercomp.application.controller.command.impl;

import by.zercomp.application.controller.JspPath;
import by.zercomp.application.controller.command.ActionCommand;
import by.zercomp.application.controller.router.Router;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EmptyCommand implements ActionCommand {
    @Override
    public Router execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return new Router(JspPath.ERROR_404);
    }
}
