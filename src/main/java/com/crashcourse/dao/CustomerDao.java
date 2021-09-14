package com.crashcourse.dao;

import java.util.List;

import com.crashcourse.entity.Customer;

public interface CustomerDao {
  // CRUD OPERATIONS ON CUSTOMER ENTITY
  public default void addCustomer(Customer custoemr) throws DaoException {
    throw new DaoException("implemented in DAO class");
  }

  public default void updateCustomer(Customer custoemr) throws DaoException {
    throw new DaoException("implemented in DAO class");
  }

  public default void getCustomer(Integer customer_id) throws DaoException {
    throw new DaoException("implemented in DAO class");
  }

  public default void deleteCustomer(Integer customer_id) throws DaoException {
    throw new DaoException("implemented in DAO class");
  }

  // QUERIES
  public default List<Customer> getAllCustomers() throws DaoException {
    throw new DaoException("implemented in DAO class");
  }

  public default List<Customer> getCustomersByCity(String city) throws DaoException {
    throw new DaoException("implemented in DAO class");
  }
}
