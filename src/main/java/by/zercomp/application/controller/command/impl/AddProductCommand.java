package by.zercomp.application.controller.command.impl;

import by.zercomp.application.controller.JspPath;
import by.zercomp.application.controller.command.ActionCommand;
import by.zercomp.application.controller.router.Router;
import by.zercomp.application.model.exception.ServiceException;
import by.zercomp.application.model.service.ProductService;
import by.zercomp.application.model.service.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static by.zercomp.application.controller.RequestParam.*;

public class AddProductCommand implements ActionCommand {

    private static final Logger log = LogManager.getLogger(AddProductCommand.class);
    private ProductService service = ServiceFactory.getInstance().getProductService();

    @Override
    public Router execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Router router = null;
        HttpSession session = request.getSession();
        Map<String, String> productParams = new HashMap<>();
        try {
            /*productParams.put(PRODUCT_ID, request.getParameter(PRODUCT_ID));
            productParams.put(PRODUCT_NAME, request.getParameter(PRODUCT_NAME));
            productParams.put(PRODUCT_ID, request.getParameter(PRODUCT_ID));
            productParams.put(PRODUCT_ID, request.getParameter(PRODUCT_ID));
            productParams.put(PRODUCT_ID, request.getParameter(PRODUCT_ID));*/
            productParams = ActionCommand.getParamsFromReq(productParams, request,
                    PRODUCT_ID, NAME, QUANTITY, PRICE, PRODUCT_BRAND, PRODUCT_CATEGORY);

        } catch (ServiceException e) {
            log.error("Product name|id : " + productParams.get(NAME) + '|' + productParams.get(PRODUCT_ID), e);
            router = new Router(JspPath.ERROR_500);
        }
        return router;
    }
}
