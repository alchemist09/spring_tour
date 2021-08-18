package com.crashcourse.programs;

import com.crashcourse.cfg.AppConfig2;
import com.crashcourse.dao.ProductDao;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class P01_GetProductCount 
{
    public static void main( String[] args )
    {
        // declare our dependency
        ProductDao dao;

        // declare a variable representing the Spring container
        AnnotationConfigApplicationContext ctx;

        // create object of spring container
        ctx = new AnnotationConfigApplicationContext(AppConfig2.class);
        System.out.println("=================================================");

        // dao = ctx.getBean("odbcDao", ProductDao.class);
        // ProductDao dao2 = ctx.getBean("odbcDao", ProductDao.class);
        ProductDao dao3 = ctx.getBean("jdbcDao", ProductDao.class);

        // System.out.println("dao2 == dao is " + (dao2 == dao));

        // System.out.println("dao is an instance of: " + dao.getClass().getName());
        // System.out.println("there are " + dao.count() + " products.");
        System.out.println("********");
        System.out.println("No. of products from database: " + dao3.count());

        ctx.close();
    }
}
