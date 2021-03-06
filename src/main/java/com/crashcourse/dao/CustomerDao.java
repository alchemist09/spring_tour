package com.crashcourse.dao;

import java.util.List;

import com.crashcourse.entity.Customer;

public interface CustomerDao {
  // CRUD OPERATIONS ON CUSTOMER ENTITY
  public default void addCustomer(Customer customer) throws DaoException {
    throw new DaoException("implemented in DAO class");
  }

  public default void updateCustomer(Customer customer) throws DaoException {
    throw new DaoException("implemented in DAO class");
  }

  public default Customer getCustomer(String customer_id) throws DaoException {
    throw new DaoException("implemented in DAO class");
  }

  public default void deleteCustomer(String customer_id) throws DaoException {
    throw new DaoException("implemented in DAO class");
  }

  // QUERIES
  public default List<Customer> getAllCustomers() throws DaoException {
    throw new DaoException("implemented in DAO class");
  }

  public default List<Customer> getCustomersByCity(String city) throws DaoException {
    throw new DaoException("implemented in DAO class");
  }

  public default List<Customer> getCustomersByRegion(String region) throws DaoException {
    throw new DaoException("implemented in DAO class");
  }

  public default List<Customer> getCustomersByPostalCode(String postal_code) throws DaoException {
    throw new DaoException("implemented in DAO class");
  }

  public default List<Customer> getCustomersByCountry(String country) throws DaoException {
    throw new DaoException("implemented in DAO class");
  }

  public default List<Customer> getCustomersByContactTitle(String title) throws DaoException {
    throw new DaoException("implemented in DAO class");
  }

  public default Customer getCustomerByPhoneNumber(String phone_no) throws DaoException {
    throw new DaoException("implemented in DAO class");
  }
}
