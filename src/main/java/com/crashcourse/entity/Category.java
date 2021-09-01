package com.crashcourse.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Category {
  private int category_id;
  private String category_name;
  private String description;
  private String pictture;
}
