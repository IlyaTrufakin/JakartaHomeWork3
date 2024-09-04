package itstep.learning.servlets;

import com.google.inject.Singleton;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@Singleton
public class HomePageServlet extends HttpServlet {
 @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  //   response.addHeader("Cache-Control", "no-cache");
  //   Cookie cookie = new Cookie("user", "test_user");
   //  response.addCookie(cookie);
     request.setAttribute("debugInfo", "Home servlet running");
     request.setAttribute("fromServlet", "HomePageServlet");
     request.setAttribute("ContentPage", "index.jsp");
     request.getRequestDispatcher("WEB-INF/views/_layout.jsp").forward(request, response);
    }
}
