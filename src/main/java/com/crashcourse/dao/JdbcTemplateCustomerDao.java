package com.crashcourse.dao;

import java.util.List;

import com.crashcourse.entity.Customer;
import com.crashcourse.entity.CustomerMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("customerDao")
public class JdbcTemplateCustomerDao implements CustomerDao {

  @Autowired(required = false)
  private JdbcTemplate template;

  @Override
  public void addCustomer(Customer c) throws DaoException {
    String sql = "INSERT INTO customers VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    template.update(sql, c.getCustomer_id(), c.getCompany_name(), c.getContact_name(), c.getContact_title(), c.getAddress(), 
                         c.getCity(), c.getRegion(), c.getPostal_code(), c.getCountry(), c.getPhone(), c.getFax());
  }

  @Override
  public void updateCustomer(Customer c) throws DaoException {
    String sql = "UPDATE customers SET company_name=?, contact_name=?, contact_title=?, address=?, city=?, ";
           sql += "region=?, postal_code=?, country=?, phone=?, fax=? WHERE customer_id = ?";
    template.update(sql, c.getCompany_name(), c.getContact_name(), c.getContact_title(), c.getAddress(), 
                         c.getCity(), c.getRegion(), c.getPostal_code(), c.getCountry(), c.getPhone(), c.getFax(), c.getCustomer_id());
  }

  @Override
  public Customer getCustomer(String customer_id) throws DaoException {
    String sql = "SELECT * FROM customers WHERE customer_id = ?";
    return template.queryForObject(sql, new CustomerMapper(), customer_id);
  }

  @Override
  public void deleteCustomer(String customer_id) throws DaoException {
    String sql = "DELETE FROM customers WHERE customer_id = ?";
    template.update(sql, customer_id);
  }

  @Override
  public List<Customer> getAllCustomers() throws DaoException {
    String sql = "SELECT * FROM customers";
    return template.query(sql, new CustomerMapper());
  }

  @Override
  public List<Customer> getCustomersByCity(String city) throws DaoException {
    String sql = "SELECT * FROM customers WHERE city = ?";
    return template.query(sql, new CustomerMapper(), city);
  }

  @Override
  public List<Customer> getCustomersByRegion(String region) throws DaoException {
    String sql = "SELECT * FROM customers WHERE region = ?";
    return template.query(sql, new CustomerMapper(), region);
  }

  @Override
  public List<Customer> getCustomersByPostalCode(String postal_code) throws DaoException {
    String sql = "SELECT * FROM customers WHERE postal_code = ?";
    return template.query(sql, new CustomerMapper(), postal_code);
  }

  @Override
  public List<Customer> getCustomersByCountry(String country) throws DaoException {
    String sql = "SELECT * FROM customers WHERE country = ?";
    return template.query(sql, new CustomerMapper(), country);
  }

  @Override
  public List<Customer> getCustomersByContactTitle(String contact_title) throws DaoException {
    String sql = "SELECT * FROM customers WHERE contact_title = ?";
    return template.query(sql, new CustomerMapper(), contact_title);
  }

  @Override
  public Customer getCustomerByPhoneNumber(String phone_no) throws DaoException {
    String sql = "SELECT * FROM customers WHERE phone = ?";
    return template.queryForObject(sql, new CustomerMapper(), phone_no);
  }
}
