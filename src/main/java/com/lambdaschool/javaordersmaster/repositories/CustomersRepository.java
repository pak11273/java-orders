package com.lambdaschool.javaordersmaster.repositories;

import com.lambdaschool.javaordersmaster.models.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomersRepository extends CrudRepository<Customer, Long>
{
    Customer save(Customer customer);

    List<Customer> findByCustnameContainingIgnoringCase(String subname);
}
