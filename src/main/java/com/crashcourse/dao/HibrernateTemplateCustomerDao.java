package com.crashcourse.dao;

import java.util.List;

import com.crashcourse.entity.Customer;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository("htCustDao")
@SuppressWarnings("unchecked")
public class HibrernateTemplateCustomerDao implements CustomerDao {

  @Autowired(required = false)
  private HibernateTemplate template;

  @Override
  public void addCustomer(Customer customer) throws DaoException {
    template.persist(customer);
  }

  @Override
  public void deleteCustomer(String customer_id) throws DaoException {
    Customer c = template.get(Customer.class, customer_id);
    template.delete(c);
  }

  @Override
  public List<Customer> getAllCustomers() throws DaoException {
    DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
    return (List<Customer>)template.findByCriteria(dc);
  }

  @Override
  public Customer getCustomer(String customer_id) throws DaoException {
    return template.get(Customer.class, customer_id);
  }

  @Override
  public Customer getCustomerByPhoneNumber(String phone_no) throws DaoException {
    return template.get(Customer.class, phone_no);
  }

  @Override
  public List<Customer> getCustomersByCity(String city) throws DaoException {
    DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
    dc.add(Restrictions.eq("city", city));
    return (List<Customer>)template.findByCriteria(dc);
  }

  @Override
  public List<Customer> getCustomersByContactTitle(String title) throws DaoException {
    DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
    dc.add(Restrictions.eq("contact_title", title));
    return (List<Customer>)template.findByCriteria(dc);
  }

  @Override
  public List<Customer> getCustomersByCountry(String country) throws DaoException {
    DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
    dc.add(Restrictions.eq("country", country));
    return (List<Customer>)template.findByCriteria(dc);
  }

  @Override
  public List<Customer> getCustomersByPostalCode(String postal_code) throws DaoException {
    // TODO Auto-generated method stub
    return CustomerDao.super.getCustomersByPostalCode(postal_code);
  }

  @Override
  public List<Customer> getCustomersByRegion(String region) throws DaoException {
    // TODO Auto-generated method stub
    return CustomerDao.super.getCustomersByRegion(region);
  }

  @Override
  public void updateCustomer(Customer customer) throws DaoException {
    template.merge(customer);
  }

  
}

