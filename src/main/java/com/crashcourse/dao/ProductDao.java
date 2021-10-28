package com.crashcourse.dao;

import java.util.List;

import com.crashcourse.entity.Product;

import org.springframework.transaction.annotation.Transactional;

@Transactional(rollbackFor = {DaoException.class}, readOnly = true)
public interface ProductDao {
  // CRUD OPERATIONS
  @Transactional(readOnly = false)
  public default void addProduct(Product product) throws DaoException {
    throw new DaoException("Method not implemented");
  }

  @Transactional(readOnly = false)
  public default void updateProduct(Product product) throws DaoException {
    throw new DaoException("Method not implemented");
  }

  public default Product getProduct(Integer product_id) throws DaoException {
    throw new DaoException("Method not implemented");
  }

  @Transactional(readOnly = false)
  public default void deleteProduct(Integer product_id) throws DaoException {
    throw new DaoException("Method not implemented");
  }

  //  QUERIES
  public default long count() throws DaoException {
    throw new DaoException("Method not implemented");
  }

  public default List<Product> getAllProducts() throws DaoException {
    throw new DaoException("Method not implemented");
  }

  public default List<Product> getProductsByPriceRange(Double min_price, Double max_price) throws DaoException {
    throw new DaoException("Method not implemented");
  }

  public default List<Product> getProductsInCategory(Integer category_id) throws DaoException {
    throw new DaoException("Method not implemented");
  }

  public default List<Product> getProductsNotInStock() throws DaoException {
    throw new DaoException("Method not implemented");
  }

  public default List<Product> getProductsOnOrder() throws DaoException {
    throw new DaoException("Method not implemented");
  }

  public default List<Product> getDiscontinuedProducts() throws DaoException {
    throw new DaoException("Method not implemented");
  }
}