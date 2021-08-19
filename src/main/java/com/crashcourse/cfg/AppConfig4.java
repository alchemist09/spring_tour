package com.crashcourse.cfg;

import javax.sql.DataSource;

import com.crashcourse.dao.JdbcProductDao;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
@PropertySource("classpath:jdbc.properties")
public class AppConfig4 {

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

  @Bean
  public JdbcProductDao jdbcDao() {
    return new JdbcProductDao();
  }

  @Bean
  public JdbcTemplate jdbcTemplate(DataSource dataSource) {
    return new JdbcTemplate(dataSource);
  }
 
 }
