package com.crashcourse.programs;

import java.util.List;
import java.util.Properties;

import javax.persistence.TypedQuery;

import com.crashcourse.entity.Category;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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

    System.out.println("\r\n=================================");
    String hql = "FROM Category";
    TypedQuery<Category> query = session.createQuery(hql, Category.class);
    List<Category> category_list = query.getResultList();

    for(Category c : category_list) {
      System.out.println(c);
    }

    System.out.println("\r\n=================================");
    Category c2 = new Category();
    c2.setCategory_id(9);
    c2.setCategory_name("Flowers");
    c2.setDescription("Tulips, Roses, Lilys, Gerbera, Orchid, Dahlia");

    Transaction tx = null;
    try {
      tx = session.beginTransaction();
      session.persist(c2);
      tx.commit();
      System.out.println("Category added successfully!!");
    } catch (Exception e) {
      tx.rollback();
      System.out.println("Error occured while trying to add cateogry to database");
    }

    session.close();
    factory.close();
  }
}
