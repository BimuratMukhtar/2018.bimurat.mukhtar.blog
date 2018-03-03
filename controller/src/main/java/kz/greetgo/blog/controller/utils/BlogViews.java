package kz.greetgo.blog.controller.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import kz.greetgo.blog.controller.errors.JsonRestError;
import kz.greetgo.blog.controller.errors.RestError;
import kz.greetgo.mvc.interfaces.*;

import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.Map;

public abstract class BlogViews implements Views {
  private final ObjectMapper objectMapper = new ObjectMapper();

  private String convertToJson(Object object) throws Exception {
    if (object == null) return null;
    return objectMapper.writer().writeValueAsString(object);
  }

  @Override
  public String toJson(Object object, RequestTunnel tunnel, Method method) throws Exception {
    return convertToJson(object);
  }

  @Override
  public String toXml(Object object, RequestTunnel tunnel, Method method) throws Exception {
    throw new UnsupportedOperationException();
  }

  @Override
  public void performRequest(MethodInvoker methodInvoker) throws Exception {
    beforeRequest();

    prepareSession(methodInvoker);

    MethodInvokedResult invokedResult = methodInvoker.invoke();
    if (invokedResult.tryDefaultRender()) return;

    if (invokedResult.error() != null) {
      performError(methodInvoker, invokedResult);
    } else {
      performRender(methodInvoker, invokedResult);
    }
  }

  protected void beforeRequest() {
  }


  private void prepareSession(MethodInvoker methodInvoker) {
  }

  @Override
  public Object getSessionParameter(ParameterContext context, RequestTunnel tunnel) {
    return null;
  }

  private void performError(MethodInvoker methodInvoker, MethodInvokedResult invokedResult) throws Exception {
    Throwable error = invokedResult.error();
    assert error != null;

    RequestTunnel tunnel = methodInvoker.tunnel();
    RequestAttributes requestAttributes = tunnel.requestAttributes();
    requestAttributes.set("ERROR_TYPE", error.getClass().getSimpleName());

    if (error instanceof JsonRestError) {
      JsonRestError restError = (JsonRestError) error;
      tunnel.setResponseStatus(restError.statusCode);
      String json = convertToJson(restError.sendingAsJsonObject);
      if (json != null) try (final PrintWriter writer = tunnel.getResponseWriter()) {
        writer.print(json);
      }
      return;
    }

    if (error instanceof RestError) {
      RestError restError = (RestError) error;
      tunnel.setResponseStatus(restError.statusCode);

      if (restError.getMessage() != null) {
        try (final PrintWriter writer = tunnel.getResponseWriter()) {
          writer.print(restError.getMessage());
        }
      }

      return;
    }

    {
      tunnel.setResponseStatus(500);
      try (final PrintWriter writer = tunnel.getResponseWriter()) {
        writer.println("Internal server error: " + error.getMessage());
        writer.println();
        error.printStackTrace(writer);
      }

      error.printStackTrace();
    }

    return;
  }

  private void performRender(MethodInvoker methodInvoker, MethodInvokedResult invokedResult) {
    assert invokedResult.error() == null;
    Object returnedValue = invokedResult.returnedValue();
    if (returnedValue == null) return;

    if (!(returnedValue instanceof String)) {
      throw new IllegalArgumentException("Cannot view " + returnedValue.getClass()
          + " with value " + returnedValue);
    }

    String place = (String) returnedValue;

    RequestTunnel tunnel = methodInvoker.tunnel();
    RequestAttributes requestAttributes = tunnel.requestAttributes();
    for (Map.Entry<String, Object> e : methodInvoker.model().data.entrySet()) {
      requestAttributes.set(e.getKey(), e.getValue());
    }

    tunnel.forward(place, true);
    return;
  }
}
