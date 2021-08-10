package com.crashcourse.cfg;

import com.crashcourse.dao.DummyProductDao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig1 {
  @Bean
  public DummyProductDao dummyDao() {
    return new DummyProductDao();
  }
 }
