package com.crashcourse.cfg;

import com.crashcourse.dao.DummyProductDao;
import com.crashcourse.dao.JdbcProductDao;
import com.crashcourse.dao.OdbcDao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

@Configuration
@PropertySource("classpath:jdbc.properties")
public class AppConfig1 {

  @Value("${jdbc.driver}")
  private String driverClassname;
  @Value("${jdbc.url}")
  private String url;
  @Value("${jdbc.user}")
  private String username;
  @Value("${jdbc.password}")
  private String password;

  public AppConfig1() {
    System.out.println("\r\nAppConfig1 instantiated......");
  }

  @Bean
  public DummyProductDao dummyDao() {
    System.out.println("dummyDao() called............");
    return new DummyProductDao();
  }

  @Scope("singleton")
  @Bean
  public JdbcProductDao jdbcDao() {
    System.out.println("jdbcDao() called..............");
    JdbcProductDao dao = new JdbcProductDao();
    dao.setDriverClassName(driverClassname);
    dao.setUrl(url);
    dao.setUsername(username);
    dao.setPassword(password);
    return dao;
  }

  @Lazy
  @Bean
  public OdbcDao odbcDao() {
    System.out.println("odbcDao() called...............");
    return new OdbcDao();
  }
 }
