package kz.greetgo.blog.stand.beans;

import kz.greetgo.blog.stand.utils.WebAppContextRegistration;
import kz.greetgo.depinject.core.Bean;
import org.eclipse.jetty.servlet.FilterHolder;
import org.eclipse.jetty.webapp.WebAppContext;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.EnumSet;
import java.util.Enumeration;

@Bean
public class CrossOriginFilterRegistration implements WebAppContextRegistration, Filter {

  @Override
  public void registerTo(WebAppContext webAppContext) {
    webAppContext.addFilter(new FilterHolder(this), "/*", EnumSet.of(DispatcherType.REQUEST));
    printRegistration();
  }

  @Override
  public double priority() {
    return 0;
  }

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {

  }

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    if (!(servletRequest instanceof HttpServletRequest) || !(servletResponse instanceof HttpServletResponse)) {
      throw new ServletException(getClass().getSimpleName() + " can work only with HTTP protocol");
    }
    HttpServletRequest request = (HttpServletRequest) servletRequest;
    HttpServletResponse response = (HttpServletResponse) servletResponse;

    response.addHeader("Access-Control-Allow-Credentials", "true");
    response.addHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));

    response.addHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
    response.addHeader("Access-Control-Allow-Headers", "origin,x-requested-with,access-control-request-headers," +
        "content-type,access-control-request-method,accept,token");
    response.addHeader("Access-Control-Max-Age", "1800");

    if ("OPTIONS".equals(request.getMethod())) {
      response.setStatus(200);
      return;
    }

    filterChain.doFilter(request, response);
  }

  @SuppressWarnings("unused")
  private void printRequestInfo(HttpServletRequest request) {
    System.out.println("request.getRequestURL() = " + request.getRequestURL());
    System.out.println("origin = " + extractOrigin(request.getRequestURL()));
    System.out.println("request.getServerName() = " + request.getServerName());
    System.out.println("request.getServerPort() = " + request.getServerPort());
    System.out.println("request.getProtocol() = " + request.getProtocol());
    System.out.println("request.getRemoteAddr() = " + request.getRemoteAddr());
    System.out.println("request.getRemoteHost() = " + request.getRemoteHost());
    System.out.println("request.getRemotePort() = " + request.getRemotePort());
    System.out.println("request.getRemoteUser() = " + request.getRemoteUser());

    Enumeration<String> headerNames = request.getHeaderNames();
    while (headerNames.hasMoreElements()) {
      String headName = headerNames.nextElement();
      String headValue = request.getHeader(headName);
      System.out.println("headName = " + headName + ", headValue = " + headValue);
    }
  }

  private static String extractOrigin(CharSequence url) {
    String s = url.toString();
    int i1 = s.indexOf("://");
    if (i1 < 0) throw new IllegalArgumentException("It is not URL: " + url);
    int i2 = s.indexOf('/', i1 + 3);
    if (i2 < 0) return s;
    return s.substring(0, i2);
  }

  @Override
  public void destroy() {

  }
}
