package com.crashcourse.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "categories")
@ToString(exclude = { "picture" })
@Getter
@Setter
@NoArgsConstructor
public class Category {
  @Id
  private int category_id;
  private String category_name;
  private String description;
  private byte[] picture;
}
