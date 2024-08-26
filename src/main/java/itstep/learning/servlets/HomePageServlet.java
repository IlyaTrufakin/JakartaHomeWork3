package itstep.learning.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("")
public class HomePageServlet extends HttpServlet {
 @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     request.setAttribute("fromServlet", "HomePageServlet");
     request.setAttribute("ContentPage", "index.jsp");
     request.getRequestDispatcher("WEB-INF/views/_layout.jsp").forward(request, response);
    }
}
