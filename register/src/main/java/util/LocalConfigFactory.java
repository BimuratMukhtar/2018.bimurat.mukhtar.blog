package util;

import kz.greetgo.conf.hot.HotConfigFactory;

public abstract class LocalConfigFactory extends HotConfigFactory {
  @Override
  protected String getBaseDir() {
    return App.appDir() + "/conf";
  }
}
