package com.crashcourse.programs;

import java.util.Properties;

public class P04_HibernateExample {
  public static void main(String[] args) {
    Properties props = new Properties();
    props.setProperty("hibernate.connection.driver_class", "org.h2.Driver");
    props.setProperty("hibernate.connection.url", "jdbc:h2:tcp://localhost/~/spring_app_db");
    props.setProperty("hibernate.connection.username", "sa");
    props.setProperty("hibernate.connection.password", "");
  }
}
