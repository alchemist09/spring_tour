package com.crashcourse.programs;

import com.crashcourse.cfg.AppConfig4;
import com.crashcourse.entity.Category;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.orm.hibernate5.HibernateTemplate;

public class P06_TestingHibernateTemplate {
  public static void main(String[] args) {
    AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig4.class);

    HibernateTemplate ht = ctx.getBean(HibernateTemplate.class);

    Category c1 = ht.get(Category.class, 1);
    System.out.println(c1);

    ctx.close();
  }
}
