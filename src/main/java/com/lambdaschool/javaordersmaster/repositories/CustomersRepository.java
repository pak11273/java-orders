package com.lambdaschool.javaordersmaster.repositories;

import com.lambdaschool.javaordersmaster.models.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomersRepository extends CrudRepository<Customer, Long> {
}
