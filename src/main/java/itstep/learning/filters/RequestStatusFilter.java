package itstep.learning.filters;

import com.google.inject.Singleton;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.core.*;
import java.util.logging.Logger;
import java.io.IOException;
import jakarta.servlet.http.HttpServletResponseWrapper;
import static jakarta.ws.rs.core.Response.Status.fromStatusCode;

@Singleton
public class RequestStatusFilter implements Filter {
    private static final Logger logger = Logger.getLogger(RequestStatusFilter.class.getName());

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("RequestStatusFilter выполняется");
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        // Обертка для захвата статуса
//        HttpServletResponseWrapper wrappedResponse = new HttpServletResponseWrapper(res) {
//            private int httpStatus = SC_OK;
//
//            @Override
//            public void setStatus(int sc) {
//                super.setStatus(sc);
//                this.httpStatus = sc;
//            }
//
//            @Override
//            public void sendError(int sc, String msg) throws IOException {
//                super.sendError(sc, msg);
//                this.httpStatus = sc;
//            }
//
//            @Override
//            public int getStatus() {
//                return this.httpStatus;
//            }
//        };


        System.out.println("get status before filter executed");

        // Сохраняем текущий статус после выполнения фильтра
        //int statusCode = wrappedResponse.getStatus();
        int statusCode = res.getStatus();
        Response.Status status = fromStatusCode(statusCode);
        String statusMessage = (status != null) ? status.toString() : "Unknown";
        String statusCodeFamily = (status != null) ? status.getFamily().toString() : "Unknown";
        StatusCodeInfo statusCodeInfo = new StatusCodeInfo(statusCode, statusMessage, statusCodeFamily);
        req.setAttribute("StatusCodeInfo", statusCodeInfo);


        // Выполняем следующий фильтр
        // chain.doFilter(request, wrappedResponse);
        chain.doFilter(req, res);


        System.out.println("get status after filter executed");


    }
}
