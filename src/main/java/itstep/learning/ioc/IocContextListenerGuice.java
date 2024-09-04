package itstep.learning.ioc;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;

public class IocContextListenerGuice extends GuiceServletContextListener {
    @Override
    protected Injector getInjector() {
        return Guice.createInjector(
                new ServiceModule(),
                new WebModule()
        );
    }
}



//    return Guice.createInjector(new ServletModule() {
//        @Override
//        protected void configureServlets() {
//            serve("/").with(HomePageServlet.class);
//            serve("/db").with(DbServlet.class);
//            serve("/logging").with(LoggingServlet.class);
//            serve("/error").with(ErrorServlet.class);
//            // Добавьте другие сервлеты по необходимости
//        }
