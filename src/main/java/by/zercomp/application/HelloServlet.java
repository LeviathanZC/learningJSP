package by.zercomp.application;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {

    public void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        PrintWriter pw = httpServletResponse.getWriter();
        pw.println("<html>");
        pw.println("<h1>Hello World!</h1>");
        pw.println("</html>");;
    }




}
