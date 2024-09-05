package itstep.learning.ioc;

import com.google.inject.Singleton;
import itstep.learning.filters.*;
import itstep.learning.servlets.*;

public class WebModule extends com.google.inject.servlet.ServletModule {
    @Override
    protected void configureServlets() {
        bind(HomePageServlet.class).in(Singleton.class);
        bind(DbServlet.class).in(Singleton.class);
        bind(ErrorServlet.class).in(Singleton.class);
        bind(DebugInfoServlet.class).in(Singleton.class);
        bind(LoggingServlet.class).in(Singleton.class);

        filter("/*").through(CharsetEncodingFilter.class);
 //       filter("/*").through(RequestStatusFilter.class);

        serve("/").with(HomePageServlet.class);
        serve("/db").with(DbServlet.class);
        serve("/logging").with(LoggingServlet.class);
        serve("/error").with(ErrorServlet.class);
        serve("/api/debug-info").with(DebugInfoServlet.class);
        super.configureServlets();
    }
}
