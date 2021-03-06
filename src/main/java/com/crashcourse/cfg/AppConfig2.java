package com.crashcourse.cfg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.crashcourse.dao.JdbcProductDao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

@Configuration
@PropertySource("classpath:jdbc.properties")
public class AppConfig2 {

  @Value("${jdbc.driver}")
  private String driverClassname;
  @Value("${jdbc.url}")
  private String url;
  @Value("${jdbc.user}")
  private String username;
  @Value("${jdbc.password}")
  private String password;

  @Scope("prototype")
  @Bean
  public JdbcProductDao jdbcDao() {
    return new JdbcProductDao();
  }

  @Scope("prototype")
  @Bean
  public Connection connection() throws ClassNotFoundException, SQLException {
    Class.forName(driverClassname);
    return DriverManager.getConnection(url, username, password);
  }
  
 }
