package com.crashcourse.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CustomerMapper implements RowMapper<Customer> {
  public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
    Customer c = new Customer();
    c.setCustomer_id(rs.getString("customer_id"));
    c.setCompany_name(rs.getString("company_name"));
    c.setContact_name(rs.getString("contact_name"));
    c.setContact_title(rs.getString("contact_title"));
    c.setAddress(rs.getString("address"));
    c.setCity(rs.getString("city"));
    c.setRegion(rs.getString("region"));
    c.setPostal_code(rs.getString("postal_code"));
    c.setCountry(rs.getString("country"));
    c.setPhone(rs.getString("phone"));
    c.setFax(rs.getString("fax"));
    return c;
  }  
}
