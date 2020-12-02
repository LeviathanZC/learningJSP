package by.zercomp.application.controller.command;

import by.zercomp.application.controller.router.Router;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@FunctionalInterface
public interface ActionCommand {

    Router execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

    static Map<String, String> getParamsFromReq(Map<String, String> src, HttpServletRequest request, String... paramNames) {
        for (String paramName : paramNames) {
            src.put(paramName, request.getParameter(paramName));
        }
        return src;
    }
}
