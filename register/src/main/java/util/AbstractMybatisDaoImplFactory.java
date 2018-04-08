package util;

import kz.greetgo.depinject.core.BeanFactory;
import org.apache.ibatis.binding.MapperMethod;
import org.apache.ibatis.builder.annotation.MapperAnnotationBuilder;
import org.apache.ibatis.reflection.ExceptionUtil;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class AbstractMybatisDaoImplFactory implements BeanFactory {

  protected abstract SqlSession getSqlSession();

  protected abstract Configuration getConfiguration();

  private final Map<Class<?>, Object> cache = new ConcurrentHashMap<>();

  @Override
  public Object createBean(Class<?> beanClass) {
    {
      Object ret = cache.get(beanClass);
      if (ret != null) return ret;
    }
    synchronized (this) {
      {
        Object ret = cache.get(beanClass);
        if (ret != null) return ret;
      }
      {
        Object ret = createBean0(beanClass);
        cache.put(beanClass, ret);
        return ret;
      }
    }
  }

  private Object createBean0(Class<?> beanClass) {
    Configuration configuration = getConfiguration();
    configuration.addMapper(beanClass);

    {
      MapperAnnotationBuilder parser = new MapperAnnotationBuilder(configuration, beanClass);
      parser.parse();
    }

    return Proxy.newProxyInstance(
      getClass().getClassLoader(),
      new Class<?>[]{beanClass},
      new ImplInvocationHandler(beanClass)
    );
  }

  private final Map<Method, MapperMethod> methodCache = new ConcurrentHashMap<>();


  private class ImplInvocationHandler implements InvocationHandler {
    final Class<?> mapperInterface;

    public ImplInvocationHandler(Class<?> mapperInterface) {
      this.mapperInterface = mapperInterface;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

      if (Object.class.equals(method.getDeclaringClass())) {
        try {
          return method.invoke(this, args);
        } catch (Throwable t) {
          throw ExceptionUtil.unwrapThrowable(t);
        }
      }

      final MapperMethod mapperMethod = cachedMapperMethod(method);

      try (SqlSession sqlSession = getSqlSession()) {
        return mapperMethod.execute(sqlSession, args);
      } catch (Throwable t) {
        throw ExceptionUtil.unwrapThrowable(t);
      }
    }

    private MapperMethod cachedMapperMethod(Method method) {
      {
        MapperMethod mapperMethod = methodCache.get(method);
        if (mapperMethod != null) return mapperMethod;
      }
      synchronized (this) {
        {
          MapperMethod mapperMethod = methodCache.get(method);
          if (mapperMethod != null) return mapperMethod;
        }
        {
          MapperMethod mapperMethod = new MapperMethod(mapperInterface, method, getSqlSession().getConfiguration());
          methodCache.put(method, mapperMethod);
          return mapperMethod;
        }
      }
    }
  }
}
