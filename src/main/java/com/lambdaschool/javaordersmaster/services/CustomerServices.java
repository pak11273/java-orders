package com.lambdaschool.javaordersmaster.services;

import com.lambdaschool.javaordersmaster.models.Customer;

import java.util.List;

public interface CustomerServices {
    Customer save(Customer customer);

    List<Customer> findAllCustomers();

    Customer findCustomerById(long custid);

    List<Customer> findByNameLike(String subname);

    void delete(long id);
}
