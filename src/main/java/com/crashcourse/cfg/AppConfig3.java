package com.crashcourse.cfg;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@ComponentScan(basePackages = {"com.crashcourse.dao"})
@Configuration
@PropertySource("classpath:jdbc.properties")
public class AppConfig3 {

  @Value("${jdbc.driver}")
  private String driverClassname;
  @Value("${jdbc.url}")
  private String url;
  @Value("${jdbc.user}")
  private String username;
  @Value("${jdbc.password}")
  private String password;

  @Bean
  public DataSource dataSource() {
    BasicDataSource bds = new BasicDataSource();
    bds.setDriverClassName(driverClassname);
    bds.setUrl(url);
    bds.setUsername(username);
    bds.setPassword(password);

    bds.setInitialSize(10);
    bds.setMaxTotal(100);
    bds.setMaxWaitMillis(500);
    bds.setMaxIdle(50);
    bds.setMinIdle(2);
    return bds;
  }
 
 }
