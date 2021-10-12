package com.crashcourse.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

  @Column(insertable = false, updatable = false)
  private int supplier_id;

  @ManyToOne
  @JoinColumn(name = "supplier_id")
  private Supplier supplier;

  @Column(insertable = false, updatable = false)
  private int category_id;

  @ManyToOne
  @JoinColumn(name = "category_id")
  private Category category;

  private String quantity_per_unit;
  private double unit_price;
  private int units_in_stock;
  private int units_on_order;
  private int reorder_level;
  private int discontinued;
}
