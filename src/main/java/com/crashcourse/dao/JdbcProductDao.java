package com.crashcourse.dao;

public class JdbcProductDao implements ProductDao {
  private String driverClassName;
  private String url;
  private String username;
  private String password;

  /**
   * Count the number of records in database
   */
  public long count() {
    return 100;
  }
}
