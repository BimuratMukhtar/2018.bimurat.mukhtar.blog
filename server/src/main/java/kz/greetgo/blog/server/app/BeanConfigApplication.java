package kz.greetgo.blog.server.app;

import beans.postgres.AllBeanConfig;
import kz.greetgo.blog.server.beans.BeanConfigServer;
import kz.greetgo.depinject.core.BeanConfig;
import kz.greetgo.depinject.core.Include;

@BeanConfig
@Include({BeanConfigServer.class, AllBeanConfig.class})
public class BeanConfigApplication {}
