package com.crashcourse.programs;

import java.util.Map;

import com.crashcourse.entity.Region;
import com.crashcourse.entity.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.crashcourse.cfg.AppConfig4;
import com.crashcourse.entity.Category;
import com.crashcourse.entity.CategoryMapper;
import com.crashcourse.entity.CustomerMapper;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class P02_TestingJdbcTemplate {

  static JdbcTemplate template;

  public static void main(String[] args) {
    AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig4.class);
    template = ctx.getBean(JdbcTemplate.class);

    // addShipper();

    // updateShipperDetails(4, "(315) 246-7799");
    // printProductCount();
    // printShipperName(4);
    // printProductDetails(3);
    // printAllShippers();
    // printAllShipperNames();
    // printAllCategories();
    // getCategory(3);
    // printAllRegions();
    printCustomersFromCountries("France");

    ctx.close();
  }

  static void addShipper() {
    int shipper_id = 4;
    String company_name = "Alibaba";
    String phone = "+1 328561135";
    String query = "INSERT INTO shippers values (?, ?, ?)";
    template.update(query, shipper_id, company_name, phone);
    System.out.println("New shipper added to database");
  }

  static void updateShipperDetails(int id, String phone) {
    String query = "UPDATE shippers SET phone=? WHERE shipper_id=?";
    template.update(query, phone, id);
    System.out.println("Details of shipper updated!!!");
  }

  static void printProductCount() {
    String query = "SELECT COUNT(*) FROM products";
    Integer productCount = template.queryForObject(query, Integer.class);
    System.out.println("There are " + productCount + " products");
  }

  static void printShipperName(int shipper_id) {
    String query = "SELECT company_name FROM shippers WHERE shipper_id = ?";
    String shipperName = template.queryForObject(query, String.class, shipper_id);
    System.out.println("Shipper Name: " + shipperName);
  }

  static void printProductDetails(int product_id) {
    String query = "SELECT * FROM products WHERE product_id = ?";
    Map<String, Object> result = template.queryForMap(query, product_id);
    for(String key : result.keySet()) {
      System.out.println(key + " ---> " + result.get(key));
    }
  }

  static void printAllShippers() {
    String query = "SELECT * FROM shippers";
    List<Map<String, Object>> result = template.queryForList(query);
    for(Map<String, Object> shipper : result) {
      System.out.println(shipper.get("company_name") + " ----> " + shipper.get("phone"));
      System.out.println("==============================\r\n");
    }
  }

  static void printAllShipperNames() {
    String query = "SELECT company_name FROM shippers";
    List<String> shipper_names = template.queryForList(query, String.class);
    for(String name : shipper_names) {
      System.out.println(name);
    }
  }

  static void printAllCategories() {
    String query = "SELECT * FROM categories";
    List<Category> cg_list = template.query(query, new CategoryMapper());
    for(Category cg : cg_list) {
      System.out.println(cg.getCategory_name() + "    " + cg.getDescription() + "    " + cg.getPictture());
    }
  }

  static void getCategory(int category_id) {
    String query = "SELECT * FROM categories WHERE category_id = ?";
    Category c = template.queryForObject(query, new CategoryMapper(), category_id);
    System.out.println(c.getCategory_name());
    System.out.println(c.getDescription());
  }

  static void printAllRegions() {
    RowMapper<Region> rm = new RowMapper<Region>() {
      public Region mapRow(ResultSet rs, int rowNum) throws SQLException {
        Region rg = new Region();
        rg.setRegion_id(rs.getInt("region_id"));
        rg.setRegion_description(rs.getString("region_description"));
        return rg;
      }
    };

    String query = "SELECT * FROM regions";
    List<Region> region_list = template.query(query, rm);
    for(Region region : region_list) {
      System.out.println(region.getRegion_description());
    }
  }

  static void printCustomersFromCountries(String c1) {
    String query = "SELECT * FROM customers";
    List<Customer> customers = template.query(query, new CustomerMapper());
    for(Customer c : customers) {
      System.out.println(c.getContact_name());
      System.out.println(c.getContact_title());
      System.out.println(c.getAddress());
      System.out.println(c.getCity());
      System.out.println(c.getCountry());
      System.out.println(c.getPhone());
      System.out.println("====================================\r\n");
    }
  }
}
