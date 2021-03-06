package com.crashcourse.programs;

import java.util.List;

import com.crashcourse.cfg.AppConfig4;
import com.crashcourse.dao.DaoException;
import com.crashcourse.dao.ProductDao;
import com.crashcourse.entity.Product;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class P06_TestingHibernateTemplateProductDao {
  public static void main(String[] args) throws DaoException {
    AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig4.class);

    ProductDao dao = ctx.getBean("htDao", ProductDao.class);
    System.out.println("dao is an instance of " + dao.getClass().getName());
    List<Product> product_list = dao.getAllProducts();
    System.out.println("There are " + product_list.size() + " products in the database");

    Double min_price = 50.0, max_price = 200.0;
    product_list = dao.getProductsByPriceRange(min_price, max_price);
    System.out.println("There are " + product_list.size() + " products between $" + min_price + " and $" + max_price);

    min_price = 200.0;
    max_price = 50.0;
    product_list = dao.getProductsByPriceRange(min_price, max_price);
    System.out.println("There are " + product_list.size() + " products between $" + min_price + " and $" + max_price);

    product_list = dao.getDiscontinuedProducts();
    System.out.println("There are " + product_list.size() + " discontinued products");

    long pc = dao.count();
    System.out.println("There are " + pc + " products avaiable");

    Product p = dao.getProduct(1);
    System.out.println(p.getProduct_name() + " -----> " + p.getUnit_price());

    try {
      p.setUnit_price(p.getUnit_price() + 1);
      dao.updateProduct(p);
      System.out.println("new product price is " + p.getUnit_price());
    } catch (DaoException e) {
      System.out.println("\r\nAn error occured while trying to update product details: " + e.getMessage());
    }

    System.out.println("\r\nProgram execution continues before exiting");
    

    ctx.close();
  }
}
