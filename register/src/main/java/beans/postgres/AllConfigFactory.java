package beans.postgres;

import config.DbConfig;
import kz.greetgo.conf.hot.HotConfigFactory;
import kz.greetgo.depinject.core.Bean;
import util.App;

@Bean
public class AllConfigFactory extends HotConfigFactory {

    public DbConfig createDbConfig(){
        return createConfig(DbConfig.class);
    }

    @Override
    protected String getBaseDir() {
        return App.appDir() + "/conf";
    }
}
