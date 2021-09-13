package com.crashcourse.programs;

import java.util.Properties;

import com.crashcourse.entity.Category;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class P04_HibernateExample {
  public static void main(String[] args) {
    Properties props = new Properties();
    props.setProperty("hibernate.connection.driver_class", "org.h2.Driver");
    props.setProperty("hibernate.connection.url", "jdbc:h2:tcp://localhost/~/spring_app_db");
    props.setProperty("hibernate.connection.username", "sa");
    props.setProperty("hibernate.connection.password", "");
    props.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");

    Configuration cfg = new Configuration();
    cfg.setProperties(props);
    cfg.addAnnotatedClass(Category.class);

    SessionFactory factory = cfg.buildSessionFactory();
    Session session = factory.openSession();

    Category c1 = session.get(Category.class, 1);
    System.out.println(c1);

    session.close();
    factory.close();
  }
}
