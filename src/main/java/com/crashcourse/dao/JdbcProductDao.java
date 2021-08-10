package com.crashcourse.dao;

public class JdbcProductDao implements ProductDao {
  /**
   * Count the number of records in database
   */
  public long count() {
    return 100;
  }
}
