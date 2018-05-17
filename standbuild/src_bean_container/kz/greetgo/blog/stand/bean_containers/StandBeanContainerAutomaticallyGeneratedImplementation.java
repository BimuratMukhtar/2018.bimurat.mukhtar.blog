package kz.greetgo.blog.stand.bean_containers;
public final class StandBeanContainerAutomaticallyGeneratedImplementation implements kz.greetgo.blog.stand.bean_containers.StandBeanContainer{

  private final java.lang.Object forSynchronizedBlocks = new java.lang.Object();

  //
  // Bean container methods
  //

  @java.lang.Override
  public kz.greetgo.blog.stand.beans.StandServer standServer() {
    return getter_native_StandServer_6.get();
  }

  //
  // Bean creations
  //

  private final java.util.concurrent.atomic.AtomicReference<kz.greetgo.blog.controller.controller.AuthController> cachedValue_native_AuthController_1 = new java.util.concurrent.atomic.AtomicReference<>(null);
  private final kz.greetgo.depinject.core.BeanGetter<kz.greetgo.blog.controller.controller.AuthController> getter_native_AuthController_1 = this::get_native_AuthController_1;
  private kz.greetgo.blog.controller.controller.AuthController get_native_AuthController_1 () {
    {
      kz.greetgo.blog.controller.controller.AuthController x = cachedValue_native_AuthController_1.get();
      if (x != null) return x;
    }
    synchronized (forSynchronizedBlocks) {
      {
        kz.greetgo.blog.controller.controller.AuthController x = cachedValue_native_AuthController_1.get();
        if (x != null) return x;
      }
      try {
        kz.greetgo.blog.controller.controller.AuthController localValue = new kz.greetgo.blog.controller.controller.AuthController();
        localValue.authBean = (kz.greetgo.depinject.core.BeanGetter<kz.greetgo.blog.controller.register.AuthRegister>)(java.lang.Object)getter_native_AuthRegisterImpl_2;
        cachedValue_native_AuthController_1.set(localValue);
        return localValue;
      } catch (java.lang.Exception e) {
        if (e instanceof java.lang.RuntimeException) throw (java.lang.RuntimeException) e;
        throw new java.lang.RuntimeException(e);
      }
    }
  }

  private final java.util.concurrent.atomic.AtomicReference<kz.greetgo.blog.stand.auth_impl.AuthRegisterImpl> cachedValue_native_AuthRegisterImpl_2 = new java.util.concurrent.atomic.AtomicReference<>(null);
  private final kz.greetgo.depinject.core.BeanGetter<kz.greetgo.blog.stand.auth_impl.AuthRegisterImpl> getter_native_AuthRegisterImpl_2 = this::get_native_AuthRegisterImpl_2;
  private kz.greetgo.blog.stand.auth_impl.AuthRegisterImpl get_native_AuthRegisterImpl_2 () {
    {
      kz.greetgo.blog.stand.auth_impl.AuthRegisterImpl x = cachedValue_native_AuthRegisterImpl_2.get();
      if (x != null) return x;
    }
    synchronized (forSynchronizedBlocks) {
      {
        kz.greetgo.blog.stand.auth_impl.AuthRegisterImpl x = cachedValue_native_AuthRegisterImpl_2.get();
        if (x != null) return x;
      }
      try {
        kz.greetgo.blog.stand.auth_impl.AuthRegisterImpl localValue = new kz.greetgo.blog.stand.auth_impl.AuthRegisterImpl();
        cachedValue_native_AuthRegisterImpl_2.set(localValue);
        return localValue;
      } catch (java.lang.Exception e) {
        if (e instanceof java.lang.RuntimeException) throw (java.lang.RuntimeException) e;
        throw new java.lang.RuntimeException(e);
      }
    }
  }

  private final java.util.concurrent.atomic.AtomicReference<kz.greetgo.blog.stand.beans.CrossOriginFilterRegistration> cachedValue_native_CrossOriginFilterRegistration_3 = new java.util.concurrent.atomic.AtomicReference<>(null);
  private final kz.greetgo.depinject.core.BeanGetter<kz.greetgo.blog.stand.beans.CrossOriginFilterRegistration> getter_native_CrossOriginFilterRegistration_3 = this::get_native_CrossOriginFilterRegistration_3;
  private kz.greetgo.blog.stand.beans.CrossOriginFilterRegistration get_native_CrossOriginFilterRegistration_3 () {
    {
      kz.greetgo.blog.stand.beans.CrossOriginFilterRegistration x = cachedValue_native_CrossOriginFilterRegistration_3.get();
      if (x != null) return x;
    }
    synchronized (forSynchronizedBlocks) {
      {
        kz.greetgo.blog.stand.beans.CrossOriginFilterRegistration x = cachedValue_native_CrossOriginFilterRegistration_3.get();
        if (x != null) return x;
      }
      try {
        kz.greetgo.blog.stand.beans.CrossOriginFilterRegistration localValue = new kz.greetgo.blog.stand.beans.CrossOriginFilterRegistration();
        cachedValue_native_CrossOriginFilterRegistration_3.set(localValue);
        return localValue;
      } catch (java.lang.Exception e) {
        if (e instanceof java.lang.RuntimeException) throw (java.lang.RuntimeException) e;
        throw new java.lang.RuntimeException(e);
      }
    }
  }

  private final java.util.concurrent.atomic.AtomicReference<kz.greetgo.blog.stand.beans.JettyControllerRegistration> cachedValue_native_JettyControllerRegistration_4 = new java.util.concurrent.atomic.AtomicReference<>(null);
  private final kz.greetgo.depinject.core.BeanGetter<kz.greetgo.blog.stand.beans.JettyControllerRegistration> getter_native_JettyControllerRegistration_4 = this::get_native_JettyControllerRegistration_4;
  private kz.greetgo.blog.stand.beans.JettyControllerRegistration get_native_JettyControllerRegistration_4 () {
    {
      kz.greetgo.blog.stand.beans.JettyControllerRegistration x = cachedValue_native_JettyControllerRegistration_4.get();
      if (x != null) return x;
    }
    synchronized (forSynchronizedBlocks) {
      {
        kz.greetgo.blog.stand.beans.JettyControllerRegistration x = cachedValue_native_JettyControllerRegistration_4.get();
        if (x != null) return x;
      }
      try {
        kz.greetgo.blog.stand.beans.JettyControllerRegistration localValue = new kz.greetgo.blog.stand.beans.JettyControllerRegistration();
        localValue.controllerList = (kz.greetgo.depinject.core.BeanGetter<java.util.List<kz.greetgo.blog.controller.utils.Controller>>)(java.lang.Object)getter_ref_list_Controller_8;
        localValue.view = (kz.greetgo.depinject.core.BeanGetter<kz.greetgo.mvc.interfaces.Views>)(java.lang.Object)getter_native_StandBlogViews_5;
        cachedValue_native_JettyControllerRegistration_4.set(localValue);
        return localValue;
      } catch (java.lang.Exception e) {
        if (e instanceof java.lang.RuntimeException) throw (java.lang.RuntimeException) e;
        throw new java.lang.RuntimeException(e);
      }
    }
  }

  private final java.util.concurrent.atomic.AtomicReference<kz.greetgo.blog.stand.beans.StandBlogViews> cachedValue_native_StandBlogViews_5 = new java.util.concurrent.atomic.AtomicReference<>(null);
  private final kz.greetgo.depinject.core.BeanGetter<kz.greetgo.blog.stand.beans.StandBlogViews> getter_native_StandBlogViews_5 = this::get_native_StandBlogViews_5;
  private kz.greetgo.blog.stand.beans.StandBlogViews get_native_StandBlogViews_5 () {
    {
      kz.greetgo.blog.stand.beans.StandBlogViews x = cachedValue_native_StandBlogViews_5.get();
      if (x != null) return x;
    }
    synchronized (forSynchronizedBlocks) {
      {
        kz.greetgo.blog.stand.beans.StandBlogViews x = cachedValue_native_StandBlogViews_5.get();
        if (x != null) return x;
      }
      try {
        kz.greetgo.blog.stand.beans.StandBlogViews localValue = new kz.greetgo.blog.stand.beans.StandBlogViews();
        cachedValue_native_StandBlogViews_5.set(localValue);
        return localValue;
      } catch (java.lang.Exception e) {
        if (e instanceof java.lang.RuntimeException) throw (java.lang.RuntimeException) e;
        throw new java.lang.RuntimeException(e);
      }
    }
  }

  private final java.util.concurrent.atomic.AtomicReference<kz.greetgo.blog.stand.beans.StandServer> cachedValue_native_StandServer_6 = new java.util.concurrent.atomic.AtomicReference<>(null);
  private final kz.greetgo.depinject.core.BeanGetter<kz.greetgo.blog.stand.beans.StandServer> getter_native_StandServer_6 = this::get_native_StandServer_6;
  private kz.greetgo.blog.stand.beans.StandServer get_native_StandServer_6 () {
    {
      kz.greetgo.blog.stand.beans.StandServer x = cachedValue_native_StandServer_6.get();
      if (x != null) return x;
    }
    synchronized (forSynchronizedBlocks) {
      {
        kz.greetgo.blog.stand.beans.StandServer x = cachedValue_native_StandServer_6.get();
        if (x != null) return x;
      }
      try {
        kz.greetgo.blog.stand.beans.StandServer localValue = new kz.greetgo.blog.stand.beans.StandServer();
        localValue.webAppContextRegistrations = (kz.greetgo.depinject.core.BeanGetter<java.util.List<kz.greetgo.blog.stand.utils.WebAppContextRegistration>>)(java.lang.Object)getter_ref_list_WebAppContextRegistration_9;
        localValue.afterInject();
        cachedValue_native_StandServer_6.set(localValue);
        return localValue;
      } catch (java.lang.Exception e) {
        if (e instanceof java.lang.RuntimeException) throw (java.lang.RuntimeException) e;
        throw new java.lang.RuntimeException(e);
      }
    }
  }

  private final java.util.concurrent.atomic.AtomicReference<kz.greetgo.blog.stand.beans.Utf8FilterRegistration> cachedValue_native_Utf8FilterRegistration_7 = new java.util.concurrent.atomic.AtomicReference<>(null);
  private final kz.greetgo.depinject.core.BeanGetter<kz.greetgo.blog.stand.beans.Utf8FilterRegistration> getter_native_Utf8FilterRegistration_7 = this::get_native_Utf8FilterRegistration_7;
  private kz.greetgo.blog.stand.beans.Utf8FilterRegistration get_native_Utf8FilterRegistration_7 () {
    {
      kz.greetgo.blog.stand.beans.Utf8FilterRegistration x = cachedValue_native_Utf8FilterRegistration_7.get();
      if (x != null) return x;
    }
    synchronized (forSynchronizedBlocks) {
      {
        kz.greetgo.blog.stand.beans.Utf8FilterRegistration x = cachedValue_native_Utf8FilterRegistration_7.get();
        if (x != null) return x;
      }
      try {
        kz.greetgo.blog.stand.beans.Utf8FilterRegistration localValue = new kz.greetgo.blog.stand.beans.Utf8FilterRegistration();
        cachedValue_native_Utf8FilterRegistration_7.set(localValue);
        return localValue;
      } catch (java.lang.Exception e) {
        if (e instanceof java.lang.RuntimeException) throw (java.lang.RuntimeException) e;
        throw new java.lang.RuntimeException(e);
      }
    }
  }

  //
  // Bean references
  //

  private final kz.greetgo.depinject.core.BeanGetter<java.util.List<kz.greetgo.blog.controller.utils.Controller>> getter_ref_list_Controller_8 = this::get_ref_list_Controller_8;
  private java.util.List<kz.greetgo.blog.controller.utils.Controller> get_ref_list_Controller_8() {
    java.util.List<kz.greetgo.blog.controller.utils.Controller> list = new java.util.ArrayList<>();
    list.add(getter_native_AuthController_1.get());
    return list;
  }

  private final kz.greetgo.depinject.core.BeanGetter<java.util.List<kz.greetgo.blog.stand.utils.WebAppContextRegistration>> getter_ref_list_WebAppContextRegistration_9 = this::get_ref_list_WebAppContextRegistration_9;
  private java.util.List<kz.greetgo.blog.stand.utils.WebAppContextRegistration> get_ref_list_WebAppContextRegistration_9() {
    java.util.List<kz.greetgo.blog.stand.utils.WebAppContextRegistration> list = new java.util.ArrayList<>();
    list.add(getter_native_CrossOriginFilterRegistration_3.get());
    list.add(getter_native_JettyControllerRegistration_4.get());
    list.add(getter_native_Utf8FilterRegistration_7.get());
    return list;
  }
  
  //
  // Getter creations
  //
}
