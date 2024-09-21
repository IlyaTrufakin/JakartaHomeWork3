package itstep.learning.filters;

import com.google.inject.Singleton;
import itstep.learning.debug.DebugInfoHolder;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@Singleton
public class RequestStatusFilter implements Filter {
    private static final String HEADER_NAME = "X-Log-Update-Time";
    private static long lastUpdateTime = System.currentTimeMillis();

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpServletRequest httpRequest = (HttpServletRequest) request;

        // Пропускаем запросы к /api/debug-info
        if (httpRequest.getRequestURI().endsWith("/api/debug-info")) {
            chain.doFilter(request, response);
            return;
        } else {
            // Добавляем заголовок X-Log-Update-Time и обрабатываем запрос
            lastUpdateTime = System.currentTimeMillis();
            httpResponse.setHeader(HEADER_NAME, String.valueOf(lastUpdateTime));
            System.out.println("lastUpdateTime " + String.valueOf(lastUpdateTime));

            chain.doFilter(request, response); //************************************************************

            // Сохраняем статус после выполнения цепочки фильтров
            int statusCode = httpResponse.getStatus();
            String servletName = httpRequest.getServletPath();
            String requestUri = httpRequest.getRequestURI();
            String method = httpRequest.getMethod();

            // Формируем сообщение для отладки
            DebugInfoHolder debugInfo = DebugInfoHolder.getOrCreate(httpRequest.getSession());
            String formattedMessage = String.format(
                    "Запрос на сервер (выход из фильтра): \n" +
                            "Статус (код): %s\n" +
                            "Имя обрабатывающего сервлета: %s\n" +
                            "Запрошенный URI: %s\n" +
                            "Метод запроса: %s",
                    statusCode,
                    servletName != null ? servletName : "N/A",
                    requestUri != null ? requestUri : "N/A",
                    method != null ? method : "N/A"
            );
            debugInfo.addMessage(formattedMessage);

            // Обновляем время и добавляем заголовок

        }
    }

    public static void updateLogTime() {
        lastUpdateTime = System.currentTimeMillis();
    }
}
