package com.crashcourse.cfg;

import java.util.Properties;

import javax.sql.DataSource;

import com.crashcourse.entity.Category;
import com.crashcourse.entity.Customer;
import com.crashcourse.entity.Product;
import com.crashcourse.entity.Supplier;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@ComponentScan(basePackages = {"com.crashcourse.dao", "com.crashcourse.aspect"})
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
  public JdbcTemplate jdbcTemplate(DataSource dataSource) {
    return new JdbcTemplate(dataSource);
  }

  @Bean
  public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
    LocalSessionFactoryBean lsfb = new LocalSessionFactoryBean();
    lsfb.setDataSource(dataSource);
    lsfb.setAnnotatedClasses(Category.class, Product.class, Supplier.class, Customer.class);

    Properties props = new Properties();
    props.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
    // props.setProperty("hibernate.show_sql", "true");
    props.setProperty("hibernate.format_sql", "true");

    lsfb.setHibernateProperties(props);

    return lsfb;
  }

  @Bean
  public HibernateTemplate hibernateTemplate(SessionFactory sessionFactory) {
    return new HibernateTemplate(sessionFactory);
  }
 
 }
