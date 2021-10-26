package com.crashcourse.aspects;

import java.util.Arrays;

import com.crashcourse.dao.DaoException;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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
  public void logBefore(JoinPoint jp) {
    System.out.println("\r\nBefore executing " + jp.getSignature().getName());
    System.out.println("Method arguments are: " + Arrays.toString(jp.getArgs()));
  }

  @Around("execution(* com.crashcourse.dao.ProductDao.get*(Double, Double))")
  public Object swapInputs(ProceedingJoinPoint pjp) throws Throwable {
    Object[] args = pjp.getArgs();

    Double min = (Double)args[0];
    Double max = (Double)args[1];

    if(min > max) {
      args = new Object[] {max, min};
    }

    return pjp.proceed(args);
  }

  @AfterThrowing(throwing = "t", pointcut="execution(* com.crashcourse.dao..*Dao.*(..))")
  public void convertToDaoException(Throwable t) throws DaoException {
    throw new DaoException(t);
  }
}
