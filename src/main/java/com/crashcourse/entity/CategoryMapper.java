package com.crashcourse.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CategoryMapper implements RowMapper<Category> {
  public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
    Category cg = new Category();
    cg.setCategory_id(rs.getInt("category_id"));
    cg.setCategory_name(rs.getString("category_name"));
    cg.setDescription(rs.getString("description"));
    cg.setPicture(rs.getBytes("picture"));
    return cg;
  }
}
