package com.crashcourse.dao;

import java.util.List;

import com.crashcourse.entity.Product;

public interface ProductDao {
  // CRUD OPERATIONS
  public default void addProduct(Product product) throws DaoException {
    throw new DaoException();
  }

  public default void updateProduct(Product product) throws DaoException {
    throw new DaoException();
  }

  public default Product getProduct(Integer product_id) throws DaoException {
    throw new DaoException();
  }

  public default void deleteProduct(Integer product_id) throws DaoException {
    throw new DaoException();
  }

  //  QUERIES
  public long count();

  public default List<Product> getAllProducts() throws DaoException {
    throw new DaoException();
  }

  public default List<Product> getProductsByPriceRange(Double min_price, Double max_price) throws DaoException {
    throw new DaoException();
  }

  public default List<Product> getProductsInCategory(Integer category_id) throws DaoException {
    throw new DaoException();
  }

  public default List<Product> getProductsNotInStock() throws DaoException {
    throw new DaoException();
  }

  public default List<Product> getProductsOnOrder() throws DaoException {
    throw new DaoException();
  }

  public default List<Product> getDiscontinuedProducts() throws DaoException {
    throw new DaoException();
  }
}