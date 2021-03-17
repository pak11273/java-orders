package com.lambdaschool.javaordersmaster.controllers;

import com.lambdaschool.javaordersmaster.models.Customer;
import com.lambdaschool.javaordersmaster.services.CustomerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController
{
    @Autowired
    private CustomerServices customerServices;

    //http://localhost:2019/customers/orders
    @GetMapping(value="/orders", produces = "application/json")
    public ResponseEntity<?> listAllCustomers()
    {
        // Customer Service
        List<Customer> listCust= customerServices.findAllCustomers();
        return new ResponseEntity<>(listCust, HttpStatus.OK);
    }

    //http://localhost:2019/customers/customer/7
    @GetMapping(value = "/customer/{custid}", produces = "application/json")
    public ResponseEntity<?> findCustomerById(@PathVariable long custid)
    {
        Customer c = customerServices.findCustomerById(custid);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }

    //http://localhost:2019/customers/customer/77
    //http://localhost:2019/customers/namelike/mes
    //http://localhost:2019/customers/namelike/cin
}
