package com.crashcourse.dao;

public class DaoException extends Exception {
  private String message;

  public DaoException(String msg) {
    message = msg;
  }
  
  public String getMessage() {
    return message;
  }
}
