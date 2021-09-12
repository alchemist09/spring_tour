package com.crashcourse.dao;

import java.util.List;

import com.crashcourse.entity.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("jtDao")
public class JdbcTemplateProductDao implements ProductDao {

  @Autowired(required = false)
  private JdbcTemplate template;

  RowMapper<Product> productMapper = (rs, rowNum) -> {
    Product p = new Product();
    p.setProduct_id(rs.getInt("product_id"));
    p.setProduct_name(rs.getString("product_name"));
    p.setSupplier_id(rs.getInt("supplier_id"));
    p.setCategory_id(rs.getInt("category_id"));
    p.setQuantity_per_unit(rs.getString("quantity_per_unit"));
    p.setUnit_price(rs.getDouble("unit_price"));
    p.setUnits_in_stock(rs.getInt("units_in_stock"));
    p.setUnits_on_order(rs.getInt("units_on_order"));
    p.setReorder_level(rs.getInt("reorder_level"));
    p.setDiscontinued(rs.getInt("discontinued"));
    return p;
  };

  // CRUD OPERATIONS
  @Override
  public void addProduct(Product p) throws DaoException {
    String sql = "INSERT INTO products VALUES (?, ?, ?. ?, ?, ?, ?, ?, ?, ?)";
    template.update(sql, p.getProduct_id(), p.getProduct_name(), p.getSupplier_id(), p.getCategory_id(), p.getQuantity_per_unit(), p.getUnit_price(), 
                         p.getUnits_in_stock(), p.getUnits_on_order(), p.getReorder_level(), p.getDiscontinued());
  }

  public void updateProduct(Product p) throws DaoException {
    String sql = "UPDATE products SET product_name=?, supplier_id=?, category_id=?, quantity_per_unit=?, unit_price=?, units_in_stock=?, units_on_order=?, reorder_level=?, discontinued=? WHERE product_id=?";
    template.update(sql, p.getProduct_name(), p.getSupplier_id(), p.getCategory_id(), p.getQuantity_per_unit(), p.getUnit_price(), 
    p.getUnits_in_stock(), p.getUnits_on_order(), p.getReorder_level(), p.getDiscontinued(), p.getProduct_id());
  }

  public Product getProduct(Integer prod_id) throws DaoException {
    String sql = "SELECT * FROM products WHERE product_id = ?";
    Product product = template.queryForObject(sql,  productMapper, prod_id);
    return product;
  }

  public void deleteProduct(Integer product_id) throws DaoException {
    // DO A SOFT DELETE
    String sql = "UPDATE products SET discontinued = 1 WHERE product_id = ?";
    template.update(sql, product_id);
  }

  //  QUERIES
  public long count() throws DaoException {
    return ProductDao.super.count();
  }

  public List<Product> getAllProducts() throws DaoException {
    String sql = "SELECT * FROM products";
    return template.query(sql, productMapper);
  }

  public List<Product> getProductsByPriceRange(Double min_price, Double max_price) throws DaoException {
    String sql = "SELECT * FROM products WHERE unit_price BETWEEN ? AND ?";
    return template.query(sql, productMapper, min_price, max_price);
  }

  public List<Product> getProductsInCategory(Integer category_id) throws DaoException {
    String sql = "SELECT * FROM products WHERE category_id = ?";
    return template.query(sql, productMapper, category_id);
  }

  public List<Product> getProductsNotInStock() throws DaoException {
    String sql = "SELECT * FROM products WHERE unit_in_stock = 0";
    return template.query(sql, productMapper);
  }

  public List<Product> getProductsOnOrder() throws DaoException {
    String sql = "SELECT * FROM products WHERE units_on_order > 0";
    return template.query(sql, productMapper);
  }

  public List<Product> getDiscontinuedProducts() throws DaoException {
    return ProductDao.super.getDiscontinuedProducts();
  }
}
