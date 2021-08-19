package com.crashcourse.programs;

import com.crashcourse.cfg.AppConfig4;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class P02_TestingJdbcTemplate {
  public static void main(String[] args) {
    AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig4.class);

    ctx.close();
  }
}
