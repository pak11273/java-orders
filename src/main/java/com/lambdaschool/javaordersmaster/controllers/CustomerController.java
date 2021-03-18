package com.lambdaschool.javaordersmaster.controllers;

import com.lambdaschool.javaordersmaster.models.Customer;
import com.lambdaschool.javaordersmaster.repositories.CustomersRepository;
import com.lambdaschool.javaordersmaster.services.CustomerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.net.URI;
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
    //http://localhost:2019/customers/customer/77
    @GetMapping(value = "/customer/{custid}", produces = "application/json")
    public ResponseEntity<?> findCustomerById(@PathVariable long custid)
    {
        Customer c = customerServices.findCustomerById(custid);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }

    //http://localhost:2019/customers/namelike/mes
    //http://localhost:2019/customers/namelike/cin
    @GetMapping(value="/namelike/{subname}", produces = "application/json")
    public ResponseEntity<?> findCustomerByNameLike(@PathVariable String subname)
    {
        List<Customer> rtnlist = customerServices.findByNameLike(subname);
        return new ResponseEntity<>(rtnlist, HttpStatus.OK);
    }

    //http://localhost:2019/customers/customer
    @PostMapping(value = "/customer", produces = "application/json", consumes = "application/json")
    public ResponseEntity<?> addCustomer(@RequestBody @Valid Customer customer)
    {
        customer.setCustcode(0);

        Customer newCustomer =customerServices.save(customer);

        HttpHeaders responseHeaders = new HttpHeaders();
        URI newCustomerURI = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{custid}").buildAndExpand(newCustomer.getCustcode()).toUri();

        responseHeaders.setLocation(newCustomerURI);

        return new ResponseEntity<>(newCustomer, responseHeaders, HttpStatus.CREATED);

    }

    @DeleteMapping(value="/customer/{custid}")
    public ResponseEntity<?> deleteById(@PathVariable long custid)
    {
        customerServices.delete(custid);
        return new ResponseEntity<>(HttpStatus.OK);
    }


// PUT /customers/customer/{custcode} - completely replaces the customer record including associated orders with the provided data

// PATCH /customers/customer/{custcode} - updates customers with the new data. Only the new data is to be sent from the frontend client.


}