package com.crashcourse.dao;

import java.util.List;

import com.crashcourse.entity.Product;

public class HibernateTemplateProductDao implements ProductDao {

  @Override
  public void addProduct(Product product) throws DaoException {
    // TODO Auto-generated method stub
    ProductDao.super.addProduct(product);
  }

  @Override
  public long count() throws DaoException {
    // TODO Auto-generated method stub
    return ProductDao.super.count();
  }

  @Override
  public void deleteProduct(Integer product_id) throws DaoException {
    // TODO Auto-generated method stub
    ProductDao.super.deleteProduct(product_id);
  }

  @Override
  public List<Product> getAllProducts() throws DaoException {
    // TODO Auto-generated method stub
    return ProductDao.super.getAllProducts();
  }

  @Override
  public List<Product> getDiscontinuedProducts() throws DaoException {
    // TODO Auto-generated method stub
    return ProductDao.super.getDiscontinuedProducts();
  }

  @Override
  public Product getProduct(Integer product_id) throws DaoException {
    // TODO Auto-generated method stub
    return ProductDao.super.getProduct(product_id);
  }

  @Override
  public List<Product> getProductsByPriceRange(Double min_price, Double max_price) throws DaoException {
    // TODO Auto-generated method stub
    return ProductDao.super.getProductsByPriceRange(min_price, max_price);
  }

  @Override
  public List<Product> getProductsInCategory(Integer category_id) throws DaoException {
    // TODO Auto-generated method stub
    return ProductDao.super.getProductsInCategory(category_id);
  }

  @Override
  public List<Product> getProductsNotInStock() throws DaoException {
    // TODO Auto-generated method stub
    return ProductDao.super.getProductsNotInStock();
  }

  @Override
  public List<Product> getProductsOnOrder() throws DaoException {
    // TODO Auto-generated method stub
    return ProductDao.super.getProductsOnOrder();
  }

  @Override
  public void updateProduct(Product product) throws DaoException {
    // TODO Auto-generated method stub
    ProductDao.super.updateProduct(product);
  }
  
}
