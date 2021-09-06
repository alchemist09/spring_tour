package com.crashcourse.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CustomerMapper implements RowMapper<Customer> {
  public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
    Customer c = new Customer();
    return c;
  }  
}
