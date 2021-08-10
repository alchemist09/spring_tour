package com.crashcourse.cfg;

import com.crashcourse.dao.DummyProductDao;
import com.crashcourse.dao.JdbcProductDao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig1 {

  public AppConfig1() {
    System.out.println("\r\nAppConfig1 instantiated......");
  }

  @Bean
  public DummyProductDao dummyDao() {
    return new DummyProductDao();
  }

  @Bean
  public JdbcProductDao jdbcDao() {
    return new JdbcProductDao();
  }
 }
