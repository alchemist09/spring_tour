package com.crashcourse.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

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

  @Autowired
  private Connection connection;

  @Autowired
  private DataSource dataSource;

  /**
   * Create a database connection
   * @return
   */
  private Connection createConnection() throws ClassNotFoundException, SQLException {
    if(connection != null && connection.isClosed() == false) {
      return connection;
    }
    Class.forName(driverClassName);
    return DriverManager.getConnection(url, username, password);
  }

  /**
   * Count the number of records in database
   */
  public long count() {
    try(
      Connection conn = createConnection();
      PreparedStatement stmt = conn.prepareStatement("SELECT COUNT(*) FROM products");
      ResultSet rs = stmt.executeQuery();
    ) {
      rs.next();
      return rs.getLong(1);
    } catch(Exception ex) {
      throw new RuntimeException(ex);
    }
  }
}
