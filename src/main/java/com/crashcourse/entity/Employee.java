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
  private String birth_date;
  private String hire_date;
  private String address;
  private String city;
  private String region;
  private int postal_code;
  private String country;
  private String home_phone;
  private int extension;
  private String photo;
  private String notes;
  private int reports_to;
}
