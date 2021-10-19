package com.crashcourse.programs;

import java.util.List;

import com.crashcourse.cfg.AppConfig4;
import com.crashcourse.dao.DaoException;
import com.crashcourse.dao.ProductDao;
import com.crashcourse.entity.Product;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class P07_TestingHibernateTemplateProductDao {
  public static void main(String[] args) throws DaoException {
    AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig4.class);

    ProductDao dao = ctx.getBean("htDao", ProductDao.class);
    List<Product> product_list = dao.getAllProducts();
    System.out.println("There are " + product_list.size() + " products in the database");

    Double min_price = 50.0, max_price = 200.0;
    product_list = dao.getProductsByPriceRange(min_price, max_price);
    System.out.println("There are " + product_list.size() + " products between $" + min_price + " and $" + max_price);

    ctx.close();
  }
}
