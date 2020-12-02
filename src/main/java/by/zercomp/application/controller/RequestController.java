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

    }

    /*
    TODO
     Команды
     Реализации
     JspPath

     */
}
