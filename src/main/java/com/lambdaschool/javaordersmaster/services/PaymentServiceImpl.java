package com.lambdaschool.javaordersmaster.services;

import com.lambdaschool.javaordersmaster.models.Payment;
import com.lambdaschool.javaordersmaster.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service(value="paymentServices")
public class PaymentServiceImpl implements PaymentServices {
    @Autowired
    private PaymentRepository paymentRepository;

    @Transactional
    @Override
    public Payment save(Payment payment) {
        return paymentRepository.save(payment);
    }
}
