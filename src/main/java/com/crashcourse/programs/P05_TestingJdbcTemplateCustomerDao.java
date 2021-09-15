package com.crashcourse.programs;

import com.crashcourse.cfg.AppConfig4;
import com.crashcourse.dao.CustomerDao;
import com.crashcourse.dao.DaoException;
import com.crashcourse.entity.Customer;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class P05_TestingJdbcTemplateCustomerDao {
  public static void main(String[] args) throws DaoException {
    AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig4.class);

    CustomerDao dao = ctx.getBean("customerDao", CustomerDao.class);

    Customer c1 = dao.getCustomer("BSBEV");
    System.out.println(c1);

    ctx.close();
  }
}
