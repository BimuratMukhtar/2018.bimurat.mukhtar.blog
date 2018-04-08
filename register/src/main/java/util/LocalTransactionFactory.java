package util;

import kz.greetgo.db.TransactionManager;
import org.apache.ibatis.session.TransactionIsolationLevel;
import org.apache.ibatis.transaction.Transaction;
import org.apache.ibatis.transaction.TransactionFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class LocalTransactionFactory implements TransactionFactory {

  private TransactionManager transactionManager;

  public LocalTransactionFactory(TransactionManager transactionManager) {
    this.transactionManager = transactionManager;
  }

  @Override
  public void setProperties(Properties props) {}

  @Override
  public Transaction newTransaction(Connection conn) {
    throw new UnsupportedOperationException();
  }

  @Override
  public Transaction newTransaction(DataSource dataSource, TransactionIsolationLevel level, boolean autoCommit) {
    return new Transaction() {
      Connection connection = null;

      @Override
      public Connection getConnection() throws SQLException {
        if (connection == null) connection = transactionManager.getConnection(dataSource);
        return connection;
      }

      @Override
      public void commit() throws SQLException {
        throw new UnsupportedOperationException();
      }

      @Override
      public void rollback() throws SQLException {
        throw new UnsupportedOperationException();
      }

      @Override
      public void close() throws SQLException {
        transactionManager.closeConnection(dataSource, connection);
      }

      @Override
      public Integer getTimeout() throws SQLException {
        return null;
      }
    };
  }
}
