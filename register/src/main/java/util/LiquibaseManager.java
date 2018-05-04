package util;

public interface LiquibaseManager {
  void apply() throws Exception;
}
