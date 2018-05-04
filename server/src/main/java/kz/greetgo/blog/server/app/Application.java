package kz.greetgo.blog.server.app;

import kz.greetgo.depinject.Depinject;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.util.Set;

public class Application implements ServletContainerInitializer {

  @Override
  public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
    try {
      Depinject.newInstance(ApplicationBeanContainer.class).appInitializer().initialize(ctx);
    } catch (Exception e) {
      if (e instanceof RuntimeException) throw (RuntimeException) e;
      if (e instanceof ServletException) throw (ServletException) e;
      throw new RuntimeException(e);
    }
  }
}
