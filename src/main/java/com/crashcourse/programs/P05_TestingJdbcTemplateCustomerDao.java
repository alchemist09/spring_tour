package com.crashcourse.programs;

import java.util.List;

import com.crashcourse.cfg.AppConfig4;
import com.crashcourse.dao.CustomerDao;
import com.crashcourse.dao.DaoException;
import com.crashcourse.entity.Customer;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class P05_TestingJdbcTemplateCustomerDao {
  public static void main(String[] args) throws DaoException {
    AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig4.class);

    CustomerDao dao = ctx.getBean("customerDao", CustomerDao.class);

    // looking up a customer
    Customer c1 = dao.getCustomer("BSBEV");
    System.out.println(c1);

    // updating customer details
    Customer c2 = dao.getCustomer("ALFKI");
    c2.setRegion("BC");
    dao.updateCustomer(c2);
    System.out.println("\r\nCustomer details updated");

    // adding a customer
    Customer c3 = new Customer();
    c3.setCustomer_id("XXXLL");
    c3.setCompany_name("Pivotal Labs");
    c3.setContact_name("John Doe");
    c3.setContact_title("Agent");
    c3.setAddress("123 Milky Way");
    c3.setCity("Casablanca");
    c3.setRegion("SF");
    c3.setPostal_code("85890");
    c3.setCountry("Finland");
    c3.setPhone("49-163-2299");
    c3.setFax("1349-15388");

    // dao.addCustomer(c3);
    // System.out.println("\r\nAdded new customer to database");

    // deleting a customer
    // dao.deleteCustomer("XXXLL");
    // System.out.println("\r\nDeleted customer from database!!");

    // retrieve all customers
    List<Customer> customers = dao.getAllCustomers();
    System.out.println("\r\nThere are " + customers.size() + " customers in database");

    // retrieve customers by city
    List<Customer> customers_city = dao.getCustomersByCity("Sao Paulo");
    System.out.println("\r\nThere are " + customers_city.size() + " customers from Sao Paulo");

    // retrieve customers by region
    List<Customer> customers_region = dao.getCustomersByRegion("BC");
    System.out.println("\r\nThere are " + customers_region.size() + " customers from BC");

    // retrieve customers by country
    List<Customer> customers_country = dao.getCustomersByCountry("France");
    System.out.println("\r\nThere are " + customers_country.size() + " customers from France");

    // retrieve customer by phone number
    Customer cust = dao.getCustomerByPhoneNumber("(5) 555-4729");
    System.out.println("\r\n" + cust);

    // retrieve customers by contact title
    List<Customer> customers_contact_title = dao.getCustomersByContactTitle("Sales Representative");
    System.out.println("\r\nThere are " + customers_contact_title.size() + " customers with a contact title of Sales Representative");

    ctx.close();
  }
}
