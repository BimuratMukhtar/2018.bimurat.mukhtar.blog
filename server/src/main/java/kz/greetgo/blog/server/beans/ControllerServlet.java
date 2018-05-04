package kz.greetgo.blog.server.beans;

import kz.greetgo.blog.controller.utils.Controller;
import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.core.BeanGetter;
import kz.greetgo.mvc.interfaces.TunnelExecutorGetter;
import kz.greetgo.mvc.interfaces.Views;
import kz.greetgo.mvc.model.UploadInfo;
import kz.greetgo.mvc.war.AppServlet;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.unmodifiableList;

@Bean
public class ControllerServlet extends AppServlet {
  public BeanGetter<List<Controller>> controllerList;

  @Override
  protected List<Object> getControllerList() {
    List<Object> ret = new ArrayList<>();
    ret.addAll(controllerList.get());
    return unmodifiableList(ret);
  }

  public BeanGetter<Views> views;

  @Override
  protected Views getViews() {
    return views.get();
  }

  @Override
  protected UploadInfo getUploadInfo() {
    final UploadInfo ret = new UploadInfo();
    ret.maxFileSize = 50_000_000;
    ret.fileSizeThreshold = 1_000;
    return ret;
  }

  @Override
  protected void afterRegister() {

    System.err.println("[ControllerServlet] --------------------------------------");
    System.err.println("[ControllerServlet] -- USING CONTROLLERS:");
    for (TunnelExecutorGetter teg : tunnelExecutorGetters) {
      System.err.println("[ControllerServlet] --   " + teg.infoStr());
    }
    System.err.println("[ControllerServlet] --------------------------------------");

    super.afterRegister();
  }

  @Override
  protected String getTargetSubContext() {
    return "/api";
  }
}
