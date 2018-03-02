package kz.greetgo.blog.stand.bean_containers;

import kz.greetgo.blog.stand.beans.BeanConfigForPackageBeans;
import kz.greetgo.depinject.core.BeanConfig;
import kz.greetgo.depinject.core.Include;

@BeanConfig
@Include({BeanConfigForPackageBeans.class})
public class BeanConfigForStandBeanContainer {

}
