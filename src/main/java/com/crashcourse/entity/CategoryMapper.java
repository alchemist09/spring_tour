package com.crashcourse.entity;

import java.sql.ResultSet;

import org.springframework.jdbc.core.RowMapper;

public class CategoryMapper implements RowMapper<Category> {
  public Category mapRow(ResultSet rs, int rowNum) {
    Category cg = new Category();
    return cg;
  }
}
