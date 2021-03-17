package com.lambdaschool.javaordersmaster.services;

import com.lambdaschool.javaordersmaster.models.Order;
import com.lambdaschool.javaordersmaster.repositories.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

@Transactional
@Service(value = "orderService")
public class OrderServicesImpl implements OrderServices {
    @Autowired
    private OrdersRepository orderrepos;

    @Transactional
    @Override
    public Order save(Order order) {
        return orderrepos.save(order);
    }

    @Override
    public Order findById(long orderid) {
        return orderrepos.findById(orderid).orElseThrow(()-> new EntityNotFoundException("Order " + orderid + " was not found."));
    }
}
