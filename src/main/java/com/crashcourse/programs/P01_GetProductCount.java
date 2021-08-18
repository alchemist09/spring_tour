package com.crashcourse.programs;

import com.crashcourse.cfg.AppConfig2;
import com.crashcourse.dao.ProductDao;
import org.h2.jdbc.JdbcConnection;

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
        JdbcConnection cntn;

        // declare a variable representing the Spring container
        AnnotationConfigApplicationContext ctx;

        // create object of spring container
        ctx = new AnnotationConfigApplicationContext(AppConfig2.class);
        System.out.println("=================================================");

        cntn = ctx.getBean("connection", JdbcConnection.class);
        // ProductDao dao2 = ctx.getBean("odbcDao", ProductDao.class);
        dao = ctx.getBean("jdbcDao", ProductDao.class);
        ProductDao dao2 = ctx.getBean("jdbcDao", ProductDao.class);

        System.out.println("dao2 == dao is " + (dao2 == dao));

        System.out.println("cntn is an instance of: " + cntn.getClass().getName());
        // System.out.println("there are " + dao.count() + " products.");
        System.out.println("********");
        System.out.println("No. of products from database: " + dao.count());
        System.out.println("No. of products from database: " + dao2.count());

        ctx.close();
    }
}
