package com.crashcourse.programs;

import com.crashcourse.cfg.AppConfig4;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class P02_TestingJdbcTemplate {

  static JdbcTemplate template;

  public static void main(String[] args) {
    AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig4.class);

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
}
