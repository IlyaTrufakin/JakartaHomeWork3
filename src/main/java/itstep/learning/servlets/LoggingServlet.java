package itstep.learning.servlets;
import java.util.logging.Logger;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/logging")
public class LoggingServlet  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("fromServlet", "LoggingServlet");
        request.setAttribute("ContentPage", "logging.jsp");
        request.getRequestDispatcher("WEB-INF/views/_layout.jsp").forward(request, response);

    }
}
