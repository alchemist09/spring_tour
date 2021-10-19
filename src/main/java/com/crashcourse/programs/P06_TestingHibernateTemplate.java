package com.crashcourse.programs;

import com.crashcourse.cfg.AppConfig4;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.orm.hibernate5.HibernateTemplate;

public class P06_TestingHibernateTemplate {
  public static void main(String[] args) {
    AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig4.class);

    HibernateTemplate ht = ctx.getBean(HibernateTemplate.class);

    ctx.close();
  }
}
