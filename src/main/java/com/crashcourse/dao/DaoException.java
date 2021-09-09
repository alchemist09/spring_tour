package com.crashcourse.dao;

public class DaoException extends Exception {

  public DaoException() {
    super();
  }

  public DaoException(String msg) {
    super(msg);
  }

  public DaoException(Throwable cause) {
    super(cause);
  }
}
