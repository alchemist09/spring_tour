package com.crashcourse.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Product {
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
