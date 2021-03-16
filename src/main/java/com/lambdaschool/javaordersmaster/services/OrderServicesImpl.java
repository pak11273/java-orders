package com.lambdaschool.javaordersmaster.services;

import com.lambdaschool.javaordersmaster.models.Order;
import com.lambdaschool.javaordersmaster.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;

public class OrderServicesImpl implements OrderServices {
    @Autowired
    private OrderRepository orderRepository;

    @Transactional
    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }
}
