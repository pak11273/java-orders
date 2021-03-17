package com.lambdaschool.javaordersmaster.services;

import com.lambdaschool.javaordersmaster.models.Customer;
import com.lambdaschool.javaordersmaster.repositories.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "customerService")
public class CustomerServicesImpl implements CustomerServices {
    @Autowired
    private CustomersRepository custrepos;

    @Transactional
    @Override
    public Customer save(Customer customer)
    {
        return custrepos.save(customer);
    }

    @Override
    public List<Customer> findAllCustomers()
    {
        List<Customer> list = new ArrayList<>();
        custrepos.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Customer findCustomerById(long custid) {
        return custrepos.findById(custid).orElseThrow(()-> new EntityNotFoundException("Customer " + custid + " was not found."));
    }
}
