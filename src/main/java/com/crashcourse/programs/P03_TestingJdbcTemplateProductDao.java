package com.crashcourse.programs;

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
    ctx.close();
  }
}