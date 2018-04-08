package dao.postgres;

import beans.postgres.DaoImplFactory;
import kz.greetgo.depinject.core.BeanConfig;
import kz.greetgo.depinject.core.BeanScanner;


@BeanConfig(defaultFactoryClass = DaoImplFactory.class)
@BeanScanner
public class DaoBeanConfig {

}

