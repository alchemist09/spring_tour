package com.crashcourse.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "products")
@ToString
@Getter
@Setter
@NoArgsConstructor
public class Product {
  @Id
  private int product_id;
  private String product_name;
  private int supplier_id;
  private int category_id;
  private String quantity_per_unit;
  private double unit_price;
  private int units_in_stock;
  private int units_on_order;
  private int reorder_level;
  private int discontinued;
}
