package com.crashcourse.dao;

import com.crashcourse.entity.Product;

public interface ProductDao {
  // CRUD OPERATIONS
  public void addProduct(Product product) throws DaoException;
  public void updateProduct(Product product) throws DaoException;
  public Product getProduct(Integer product_id) throws DaoException;
  public void deleteProduct(Integer product_id) throws DaoException;

  //  QUERIES
  public long count();
}