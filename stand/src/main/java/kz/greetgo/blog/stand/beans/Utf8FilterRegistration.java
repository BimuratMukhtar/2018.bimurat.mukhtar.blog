package kz.greetgo.blog.stand.beans;

import kz.greetgo.blog.stand.utils.WebAppContextRegistration;
import kz.greetgo.depinject.core.Bean;
import org.eclipse.jetty.servlet.FilterHolder;
import org.eclipse.jetty.webapp.WebAppContext;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.EnumSet;

@Bean
public class Utf8FilterRegistration implements WebAppContextRegistration, Filter{

    @Override
    public void registerTo(WebAppContext webAppContext) {
        webAppContext.addFilter(new FilterHolder(this), "/*", EnumSet.of(DispatcherType.REQUEST));
    }

    @Override
    public double priority() {
        return 0;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (request instanceof HttpServletRequest) {
            String url = ((HttpServletRequest)request).getRequestURL().toString();
            String queryString = ((HttpServletRequest)request).getQueryString();
            System.out.println(url);
            System.out.println(queryString);
        }
    }

    @Override
    public void destroy() {

    }
}
