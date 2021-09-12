package com.crashcourse.programs;

import java.util.List;

import com.crashcourse.cfg.AppConfig4;
import com.crashcourse.dao.DaoException;
import com.crashcourse.dao.ProductDao;
import com.crashcourse.entity.Product;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class P03_TestingJdbcTemplateProductDao {
  public static void main(String[] args) throws DaoException {
    AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig4.class);

    ProductDao dao = ctx.getBean("jtDao", ProductDao.class);

    Product p1 = dao.getProduct(1);
    System.out.println(p1);
    
    p1.setUnit_price(p1.getUnit_price() + 1);
    dao.updateProduct(p1);
    System.out.println("Product Updated!!");

    List<Product> products = dao.getProductsByPriceRange(50.0, 200.0);
    System.out.println("There are " + products.size() + " products between $50.0 and $200.0");

    List<Product> discontinued_prodcuts = dao.getDiscontinuedProducts();
    System.out.println("There are " + discontinued_prodcuts.size() + " discontinued products");

    List<Product> out_of_stock_products = dao.getProductsNotInStock();
    System.out.println("There are " + out_of_stock_products.size() + " products that are out of stock");

    List<Product> ordered_products = dao.getProductsOnOrder();
    System.out.println("The number of products that are on order is " + ordered_products.size());

    ctx.close();
  }
}
