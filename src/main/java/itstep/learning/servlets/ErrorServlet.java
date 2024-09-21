package itstep.learning.servlets;

import itstep.learning.debug.DebugInfoHolder;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ErrorServlet extends HttpServlet {

    private void processError(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Integer statusCode = (Integer) request.getAttribute("jakarta.servlet.error.status_code");
//        String servletName = (String) request.getAttribute("jakarta.servlet.error.servlet_name");
//        String requestUri = (String) request.getAttribute("jakarta.servlet.error.request_uri");
//        Throwable throwable = (Throwable) request.getAttribute("jakarta.servlet.error.exception");
//        String method = request.getMethod();
//
//        response.setContentType("text/html;charset=UTF-8");
//
//        DebugInfoHolder debugInfo = DebugInfoHolder.getOrCreate(request.getSession());
//        debugInfo.addMessage("ErrorServlet: Error occurred");
//        debugInfo.addMessage("Status Code: " + statusCode);
//        debugInfo.addMessage("Servlet Name: " + servletName);
//        debugInfo.addMessage("Request URI: " + requestUri);
//        debugInfo.addMessage("Method: " + method);
//
//        if (throwable != null) {
//            debugInfo.addMessage("Exception: " + throwable.getMessage());
//        }




//
//        if (statusCode == 404) {
//            response.setContentType("text/html;charset=UTF-8");
//            response.getWriter().write("<h1>404 - Страница не найдена</h1>");
//            response.getWriter().write("<p>Запрошенный ресурс не существует: " + requestUri + "</p>");
//
//        } else {
//            // Обработка других ошибок
//            response.setContentType("text/html;charset=UTF-8");
//            response.getWriter().write("<h1>Произошла ошибка</h1>");
//            response.getWriter().write("<p>Код ошибки: " + statusCode + "</p>");
//            response.getWriter().write("<p>Имя сервлета: " + servletName + "</p>");
//            response.getWriter().write("<p>Запрошенный ресурс: " + requestUri + "</p>");
//        }
//



        request.setAttribute("fromServlet", "ErrorServlet");
        request.setAttribute("ContentPage", "noPageFound.jsp");
        request.getRequestDispatcher("WEB-INF/views/_layout.jsp").forward(request, response);
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processError(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processError(req, resp);
    }

}

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



