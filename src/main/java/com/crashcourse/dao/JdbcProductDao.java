package com.crashcourse.dao;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
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
