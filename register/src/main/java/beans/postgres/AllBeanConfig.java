package beans.postgres;

import dao.postgres.DaoBeanConfig;
import impl.BeanScannerForImpl;
import kz.greetgo.blog.controller.controller.BeanConfigForPackageController;
import kz.greetgo.depinject.core.BeanConfig;
import kz.greetgo.depinject.core.BeanScanner;
import kz.greetgo.depinject.core.Include;

@BeanConfig
@BeanScanner
@Include({DaoBeanConfig.class, BeanScannerForImpl.class, BeanConfigForPackageController.class})
public class AllBeanConfig {
}