package com.crashcourse.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
   * Create a database connection
   * @return
   */
  private Connection createConnection() throws ClassNotFoundException, SQLException {
    Class.forName(driverClassName);
    return DriverManager.getConnection(url, username, password);
  }

  /**
   * Count the number of records in database
   */
  public long count() {
    return 100;
  }
}
