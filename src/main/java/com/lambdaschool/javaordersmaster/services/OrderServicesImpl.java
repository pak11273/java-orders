package com.lambdaschool.javaordersmaster.services;

import com.lambdaschool.javaordersmaster.models.Order;
import com.lambdaschool.javaordersmaster.models.Payment;
import com.lambdaschool.javaordersmaster.repositories.OrdersRepository;
import com.lambdaschool.javaordersmaster.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

@Transactional
@Service(value = "orderService")
public class OrderServicesImpl implements OrderServices {
    @Autowired
    private OrdersRepository orderrepos;

    @Autowired
    private PaymentRepository paymentRepository;

    @Transactional
    @Override
    public Order save(Order order)
    {
        Order newOrder = new Order();

        if (order.getOrdnum() != 0) {
            orderrepos.findById(order.getOrdnum())
                    .orElseThrow(() -> new EntityNotFoundException("Order " + order.getOrdnum() + " not found!"));
            newOrder.setOrdnum(order.getOrdnum());
        }

        newOrder.setOrderdescription(order.getOrderdescription());
        newOrder.setOrdamount(order.getOrdamount());
        newOrder.setAdvanceamount(order.getAdvanceamount());
        newOrder.setCustomer(order.getCustomer());
        newOrder.setPayments(order.getPayments());

        //ManyToMany -> existing database entities
        newOrder.getPayments().clear();
        for (Payment p : order.getPayments()) {
            Payment newPayment = paymentRepository.findById(p.getPaymentid())
                    .orElseThrow(() -> new EntityNotFoundException("Payment " + p.getPaymentid() + " not found!"));

            newOrder.getPayments().add(newPayment);
        }

        return orderrepos.save(newOrder);
    }

    @Override
    public Order findById(long orderid) {
        return orderrepos.findById(orderid).orElseThrow(()-> new EntityNotFoundException("Order " + orderid + " was not found."));
    }
}
