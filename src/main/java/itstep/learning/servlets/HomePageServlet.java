package itstep.learning.jakartahomework3;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import java.io.IOException;


public class HomePageServlet extends HttpServlet {
 @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     request.setAttribute("fromServlet", "HomePageServlet");
     request.getRequestDispatcher("WEB-INF/views/_layout.jsp").forward(request, response);
    }
}
