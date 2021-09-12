package com.crashcourse.dao;

import java.util.List;

import com.crashcourse.entity.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("jtDao")
public class JdbcTemplateProductDao implements ProductDao {

  @Autowired(required = false)
  private JdbcTemplate template;

  // CRUD OPERATIONS
  @Override
  public void addProduct(Product product) throws DaoException {
    ProductDao.super.addProduct(product);
  }

  public void updateProduct(Product product) throws DaoException {
    ProductDao.super.updateProduct(product);
  }

  public Product getProduct(Integer product_id) throws DaoException {
    return ProductDao.super.getProduct(product_id);
  }

  public void deleteProduct(Integer product_id) throws DaoException {
    ProductDao.super.deleteProduct(product_id);
  }

  //  QUERIES
  public long count() throws DaoException {
    return ProductDao.super.count();
  }

  public List<Product> getAllProducts() throws DaoException {
    return ProductDao.super.getAllProducts();
  }

  public List<Product> getProductsByPriceRange(Double min_price, Double max_price) throws DaoException {
    return ProductDao.super.getProductsByPriceRange(min_price, max_price);
  }

  public List<Product> getProductsInCategory(Integer category_id) throws DaoException {
    return ProductDao.super.getProductsInCategory(category_id);
  }

  public List<Product> getProductsNotInStock() throws DaoException {
    return ProductDao.super.getProductsNotInStock();
  }

  public List<Product> getProductsOnOrder() throws DaoException {
    return ProductDao.super.getProductsOnOrder();
  }

  public List<Product> getDiscontinuedProducts() throws DaoException {
    return ProductDao.super.getDiscontinuedProducts();
  }
}
