package com.crashcourse.dao;

import com.crashcourse.entity.Customer;

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
}