package com.lambdaschool.javaordersmaster.repositories;

import com.lambdaschool.javaordersmaster.models.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> { }
