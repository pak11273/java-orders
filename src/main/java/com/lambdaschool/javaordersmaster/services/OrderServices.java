package com.lambdaschool.javaordersmaster.services;

import com.lambdaschool.javaordersmaster.models.Order;

public interface OrderServices {
    Order save(Order order);

    Order findById(long id);

    void delete(long id);
}

