package com.crashcourse.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("customerDao")
public class JdbcTemplateCustomerDao implements CustomerDao {

  @Autowired(required = false)
  private JdbcTemplate template;
}
