package com.lambdaschool.javaordersmaster.repositories;

import com.lambdaschool.javaordersmaster.models.Payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payment, Long> {
}
