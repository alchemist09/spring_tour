package com.crashcourse.programs;

import java.util.List;

import com.crashcourse.cfg.AppConfig4;
import com.crashcourse.dao.CustomerDao;
import com.crashcourse.dao.DaoException;
import com.crashcourse.entity.Customer;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class P07_TestingHibernateTemplateCustomerDao {
  public static void main(String[] args) throws DaoException {
    AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig4.class);

    CustomerDao dao = ctx.getBean("htCustDao", CustomerDao.class);
    List<Customer> customer_list = dao.getAllCustomers();
    System.out.println("There are " + customer_list.size() + " customers in database");

    Customer c1 = dao.getCustomer("BOTTM");
    System.out.println(c1);

    String country = "Canada";
    customer_list  = dao.getCustomersByCountry(country);
    System.out.println("There are " + customer_list.size() + " customers from " + country);

    ctx.close();
  }
}