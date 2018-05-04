package kz.greetgo.blog.server.beans;

import kz.greetgo.depinject.core.Bean;

import javax.servlet.*;
import java.io.IOException;
import java.util.EnumSet;

@Bean
public class Utf8AndTraceResetFilter implements Filter {
  public void register(ServletContext ctx) {
    FilterRegistration.Dynamic dynamic = ctx.addFilter(getClass().getName(), this);
    dynamic.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "/*");
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
    throws IOException, ServletException {

    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
    chain.doFilter(request, response);

  }

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {}

  @Override
  public void destroy() {}
}
