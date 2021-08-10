package com.crashcourse.cfg;

import com.crashcourse.dao.DummyProductDao;
import com.crashcourse.dao.JdbcProductDao;
import com.crashcourse.dao.OdbcDao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig1 {

  public AppConfig1() {
    System.out.println("\r\nAppConfig1 instantiated......");
  }

  // @Bean
  public DummyProductDao dummyDao() {
    System.out.println("dummyDao() called............");
    return new DummyProductDao();
  }

  @Bean
  public JdbcProductDao jdbcDao() {
    System.out.println("jdbcDao() called..............");
    return new JdbcProductDao();
  }

  @Bean
  public OdbcDao odbcDao() {
    System.out.println("odbcDao() called...............");
    return new OdbcDao();
  }
 }
