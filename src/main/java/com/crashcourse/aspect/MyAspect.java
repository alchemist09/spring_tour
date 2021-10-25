package com.crashcourse.aspect;

import org.springframework.stereotype.Component;

@Component
public class MyAspect {
  public MyAspect() {
    System.out.println("My Aspect instantitated!!!");
  }
}
