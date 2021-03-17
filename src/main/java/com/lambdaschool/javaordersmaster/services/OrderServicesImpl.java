package com.lambdaschool.javaordersmaster.services;

import com.lambdaschool.javaordersmaster.models.Order;
import com.lambdaschool.javaordersmaster.repositories.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;

public class OrderServicesImpl implements OrderServices {
    @Autowired
    private OrdersRepository ordersRepository;

    @Transactional
    @Override
    public Order save(Order order) {
        return ordersRepository.save(order);
    }
}
