package com.crashcourse.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {
  public MyAspect() {
    System.out.println("My Aspect instantitated!!!");
  }

  @Before("execution(* com.crashcourse.dao.ProductDao.get*(..))")
  public void logBefore() {
    System.out.println("\r\nLogging before target method execution");
  }
}
