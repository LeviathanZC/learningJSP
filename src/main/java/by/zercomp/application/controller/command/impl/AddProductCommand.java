package by.zercomp.application.controller.command.impl;

import by.zercomp.application.controller.command.ActionCommand;
import by.zercomp.application.controller.router.Router;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddProductCommand implements ActionCommand {

    private static final Logger log = LogManager.getLogger(AddProductCommand.class);

    @Override
    public Router execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Router router;
        return router;
    }
}
