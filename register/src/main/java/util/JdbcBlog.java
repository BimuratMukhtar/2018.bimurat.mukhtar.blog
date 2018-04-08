package util;

import kz.greetgo.db.AbstractJdbcWithDataSource;
import kz.greetgo.db.TransactionManager;

import javax.sql.DataSource;

public class JdbcBlog extends AbstractJdbcWithDataSource {

    DataSource dataSource;
    TransactionManager transactionManager;

    public JdbcBlog(DataSource dataSource, TransactionManager transactionManager) {
        this.dataSource = dataSource;
        this.transactionManager = transactionManager;
    }

    @Override
    protected DataSource getDataSource() {
        return null;
    }

    @Override
    protected TransactionManager getTransactionManager() {
        return null;
    }
}
