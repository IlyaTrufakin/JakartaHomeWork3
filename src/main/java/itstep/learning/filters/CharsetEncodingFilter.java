package itstep.learning.filters;

import com.google.inject.Singleton;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import java.util.logging.Logger;
import java.io.IOException;

@Singleton
public class CharsetEncodingFilter implements Filter {
    //private static final Logger logger = Logger.getLogger(CharsetEncodingFilter.class.getName());

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
         System.out.println("CharsetEncodingFilter " + ((HttpServletRequest) request).getRequestURI());
        // Установка кодировки запроса
        request.setCharacterEncoding("UTF-8");
        // Установка кодировки ответа
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        // Пропуск запроса дальше по цепочке фильтров
        chain.doFilter(request, response);
    }
}