package kz.greetgo.blog.stand.bean_containers;

import kz.greetgo.blog.controller.controller.BeanConfigForPackageController;
import kz.greetgo.blog.stand.beans.BeanConfigForPackageBeans;
import kz.greetgo.blog.stand.auth_impl.BeanConfigForPackageLoginImpl;
import kz.greetgo.depinject.core.BeanConfig;
import kz.greetgo.depinject.core.Include;

@BeanConfig
@Include({BeanConfigForPackageBeans.class,
        BeanConfigForPackageController.class,
        BeanConfigForPackageLoginImpl.class
})
public class BeanConfigForStandBeanContainer {

}
