package itstep.learning.servlets;

import com.google.gson.Gson;
import com.google.inject.Singleton;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Singleton
public class DebugInfoServlet extends HttpServlet {
    private  final Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, Object> debugInfo = new HashMap<>();
        debugInfo.put("serverTime", System.currentTimeMillis());
        debugInfo.put("requestMethod", request.getMethod());
        debugInfo.put("requestURI", request.getRequestURI());
        debugInfo.put("userAgent", request.getHeader("User-Agent"));

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(gson.toJson(debugInfo));
    }
}