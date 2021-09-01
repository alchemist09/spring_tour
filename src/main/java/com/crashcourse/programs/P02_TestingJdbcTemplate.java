package com.crashcourse.programs;

import java.util.Map;
import java.util.List;

import com.crashcourse.cfg.AppConfig4;
import com.crashcourse.entity.Category;
import com.crashcourse.entity.CategoryMapper;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

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
    printAllCategories();

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
    String query = "update shippers set phone=? where shipper_id=?";
    template.update(query, phone, id);
    System.out.println("Details of shipper updated!!!");
  }

  static void printProductCount() {
    String query = "select count(*) from products";
    Integer productCount = template.queryForObject(query, Integer.class);
    System.out.println("There are " + productCount + " products");
  }

  static void printShipperName(int shipper_id) {
    String query = "select company_name from shippers where shipper_id = ?";
    String shipperName = template.queryForObject(query, String.class, shipper_id);
    System.out.println("Shipper Name: " + shipperName);
  }

  static void printProductDetails(int product_id) {
    String query = "select * from products where product_id = ?";
    Map<String, Object> result = template.queryForMap(query, product_id);
    for(String key : result.keySet()) {
      System.out.println(key + " ---> " + result.get(key));
    }
  }

  static void printAllShippers() {
    String query = "select * from shippers";
    List<Map<String, Object>> result = template.queryForList(query);
    for(Map<String, Object> shipper : result) {
      System.out.println(shipper.get("company_name") + " ----> " + shipper.get("phone"));
      System.out.println("==============================\r\n");
    }
  }

  static void printAllShipperNames() {
    String query = "select company_name from shippers";
    List<String> shipper_names = template.queryForList(query, String.class);
    for(String name : shipper_names) {
      System.out.println(name);
    }
  }

  static void printAllCategories() {
    String query = "select * from categories";
    List<Category> cg_list = template.query(query, new CategoryMapper());
    for(Category cg : cg_list) {
      System.out.println(cg.getCategory_name() + "    " + cg.getDescription() + "    " + cg.getPictture());
    }
  }
}
