package itstep.learning.servlets;

import com.google.inject.Singleton;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Enumeration;

//@Singleton
public class ErrorServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("ErrorServlet service method called");

        Throwable throwable = (Throwable) request.getAttribute("jakarta.servlet.error.exception");
        Integer statusCode = (Integer) request.getAttribute("jakarta.servlet.error.status_code");
        String servletName = (String) request.getAttribute("jakarta.servlet.error.servlet_name");
        String requestUri = (String) request.getAttribute("jakarta.servlet.error.request_uri");

        System.out.println("Ошибка:");
        System.out.println("Status code: " + statusCode);
        System.out.println("Servlet name: " + servletName);
        System.out.println("Request URI: " + requestUri);
        if (throwable != null) {
            System.out.println("Exception: " + throwable.getMessage());
        }

        //  проверка метода запроса
        String method = request.getMethod();
        System.out.println("Request method: " + method);
        super.service(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("ErrorServlet doGet method called");
        handleError(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("ErrorServlet doPost method called");
        handleError(request, response);
    }

    private void handleError(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Handling error in ErrorServlet");

//        Throwable throwable = (Throwable) request.getAttribute("jakarta.servlet.error.exception");
//        String errorMessage;
//        System.out.println("Error: " + throwable.getMessage());
//        int statusCode = response.getStatus();
//
//
//        if (statusCode == HttpServletResponse.SC_NOT_FOUND) {
//            errorMessage = "Страница не найдена";
//        } else if (throwable instanceof SQLException) {
//            errorMessage = "Произошла ошибка при работе с базой данных: " + throwable.getMessage();
//        } else {
//            errorMessage = "Произошла неизвестная ошибка: " + throwable.getMessage();
//        }
//
//        request.setAttribute("errorMessage", errorMessage);

        //
        request.setAttribute("fromServlet", "ErrorServlet");
        request.setAttribute("ContentPage", "noPageFound.jsp");
        request.getRequestDispatcher("WEB-INF/views/_layout.jsp").forward(request, response);

    }
}