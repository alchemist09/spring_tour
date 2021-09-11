package com.crashcourse.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Employee {
  private int employee_id;
  private String last_name;
  private String first_name;
  private String title;
  private String title_of_courtesy;
}
