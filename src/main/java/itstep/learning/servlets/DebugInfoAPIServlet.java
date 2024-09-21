package itstep.learning.servlets;

import com.google.gson.Gson;
import com.google.inject.Singleton;
import itstep.learning.debug.DebugInfoHolder;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DebugInfoAPIServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DebugInfoHolder debugInfo = DebugInfoHolder.getOrCreate(request.getSession());
        List<String> messages = debugInfo.getMessages();

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Expires", "0");
        if (!messages.isEmpty()) {
            response.getWriter().write(new Gson().toJson(messages));
            debugInfo.clear();
        } else {
            response.getWriter().write("[]"); // Пустой массив, если нет новых сообщений
        }
//        Map<String, Object> debugInfo = new HashMap<>();
//        debugInfo.put("serverTime", System.currentTimeMillis());
//        debugInfo.put("requestMethod", request.getMethod());
//        debugInfo.put("requestURI", request.getRequestURI());
//        debugInfo.put("userAgent", request.getHeader("User-Agent"));
//
//        response.setContentType("application/json");
//        response.setCharacterEncoding("UTF-8");
//        response.getWriter().write(gson.toJson(debugInfo));
//        System.out.println("DebugInfoServlet: Sending response: " + gson.toJson(debugInfo));
    }
}