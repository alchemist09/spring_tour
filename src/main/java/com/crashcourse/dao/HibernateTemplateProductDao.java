package com.crashcourse.dao;

import java.util.List;

import com.crashcourse.entity.Product;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository("htDao")
@SuppressWarnings("unchecked")
public class HibernateTemplateProductDao implements ProductDao {

  @Autowired(required = false)
  private HibernateTemplate template;

  @Override
  public void addProduct(Product product) throws DaoException {
    template.persist(product);
  }

  @Override
  public void updateProduct(Product product) throws DaoException {
    template.merge(product);
  }

  @Override
  public void deleteProduct(Integer product_id) throws DaoException {
    Product p = getProduct(product_id);
    p.setDiscontinued(1);
    template.merge(p);
  }

  @Override
  public long count() throws DaoException {
    DetachedCriteria dc = DetachedCriteria.forClass(Product.class);
    dc.setProjection(Projections.rowCount());
    return (long)template.findByCriteria(dc).get(0);
  }

  @Override
  public List<Product> getAllProducts() throws DaoException {
    DetachedCriteria dc = DetachedCriteria.forClass(Product.class);
    return (List<Product>)template.findByCriteria(dc);
  }

  @Override
  public List<Product> getDiscontinuedProducts() throws DaoException {
    DetachedCriteria dc = DetachedCriteria.forClass(Product.class);
    dc.add(Restrictions.eq("discontinued", 1));
    return (List<Product>)template.findByCriteria(dc);
  }

  @Override
  public Product getProduct(Integer product_id) throws DaoException {
    return template.get(Product.class, product_id);
  }

  @Override
  public List<Product> getProductsByPriceRange(Double min_price, Double max_price) throws DaoException {
    DetachedCriteria dc = DetachedCriteria.forClass(Product.class);
    dc.add(Restrictions.between("unit_price", min_price, max_price));
    return (List<Product>)template.findByCriteria(dc);
  }

  @Override
  public List<Product> getProductsInCategory(Integer category_id) throws DaoException {
    DetachedCriteria dc = DetachedCriteria.forClass(Product.class);
    dc.add(Restrictions.eq("category_id", category_id));
    return (List<Product>)template.findByCriteria(dc);
  }

  @Override
  public List<Product> getProductsNotInStock() throws DaoException {
    DetachedCriteria dc = DetachedCriteria.forClass(Product.class);
    dc.add(Restrictions.eq("units_in_stock", 0));
    return (List<Product>)template.findByCriteria(dc);
  }

  @Override
  public List<Product> getProductsOnOrder() throws DaoException {
    DetachedCriteria dc = DetachedCriteria.forClass(Product.class);
    dc.add(Restrictions.gt("units_on_order", 0));
    return (List<Product>)template.findByCriteria(dc);
  }
  
}
