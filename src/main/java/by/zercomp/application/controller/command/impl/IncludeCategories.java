package by.zercomp.application.controller.command.impl;

import by.zercomp.application.controller.JspPath;
import by.zercomp.application.controller.command.ActionCommand;
import by.zercomp.application.controller.router.Router;
import by.zercomp.application.model.entity.Category;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class IncludeCategories implements ActionCommand {
    @Override
    public Router execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> categories = new ArrayList<>();
        request.setAttribute("categories", categories);
        request.getRequestDispatcher(JspPath.CATEGORIES).include(request, response);
        return null;
    }
}
