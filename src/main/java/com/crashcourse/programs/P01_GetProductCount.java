package com.crashcourse.programs;

import com.crashcourse.cfg.AppConfig1;
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
        ctx = new AnnotationConfigApplicationContext(AppConfig1.class);
    }
}
