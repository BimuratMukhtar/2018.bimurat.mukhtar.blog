package beans.postgres;

import config.DbConfig;
import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.core.BeanGetter;
import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.core.PostgresDatabase;
import liquibase.database.jvm.JdbcConnection;
import liquibase.resource.ClassLoaderResourceAccessor;
import util.LiquibaseManager;

import java.sql.Connection;
import java.sql.DriverManager;

@Bean
public class LiquibaseManagerImpl implements LiquibaseManager {

    public BeanGetter<DbConfig> dbConfig;

    @Override
    public void apply() throws Exception {

        Class.forName("org.postgresql.Driver");

        try (Connection connection = DriverManager.getConnection(
                dbConfig.get().url(),
                dbConfig.get().username(),
                dbConfig.get().password()
        )) {
            Database database = new PostgresDatabase();

            database.setConnection(new JdbcConnection(connection));

            {
                new Liquibase(
                        "liquibase/postgres/changelog-master.xml",

                        new ClassLoaderResourceAccessor(), database
                ).update("");
            }
        }
    }
}