package com.crashcourse.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Supplier {
  private int supplier_id;
  private String company_name;
  private String contact_name;
  private String contact_title;
  private String address;
  private String city;
  private String region;
  private String postal_code;
  private String country;
  private String phone;
  private String fax;
  private String home_page;

}