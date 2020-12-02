package by.zercomp.application.controller.command;

import by.zercomp.application.controller.router.Router;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@FunctionalInterface
public interface ActionCommand {

    Router execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
