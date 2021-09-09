package com.crashcourse.dao;

import java.util.List;

import com.crashcourse.entity.Product;

public interface ProductDao {
  // CRUD OPERATIONS
  public void addProduct(Product product) throws DaoException;
  public void updateProduct(Product product) throws DaoException;
  public Product getProduct(Integer product_id) throws DaoException;
  public void deleteProduct(Integer product_id) throws DaoException;

  //  QUERIES
  public long count();
  public List<Product> getAllProducts() throws DaoException;
  public List<Product> getProductsByPriceRange(Double min_price, Double max_price) throws DaoException;
  public List<Product> getProductsInCategory(Integer category_id) throws DaoException;
  public List<Product> getProductsNotInStock() throws DaoException;
  public List<Product> getProductsOnOrder() throws DaoException;
  public List<Product> getDiscontinuedProducts() throws DaoException;
}