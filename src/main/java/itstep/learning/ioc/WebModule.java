package itstep.learning.ioc;

import itstep.learning.filters.*;
import itstep.learning.servlets.*;

public class WebModule extends com.google.inject.servlet.ServletModule {
    @Override
    protected void configureServlets() {
        filter("/*").through(CharsetEncodingFilter.class);
        serve("/").with(HomePageServlet.class);
        serve("/db").with(DbServlet.class);
        serve("/error").with(ErrorServlet.class);
        serve("/api/debug-info").with(DebugInfoServlet.class);
        super.configureServlets();
    }
}
