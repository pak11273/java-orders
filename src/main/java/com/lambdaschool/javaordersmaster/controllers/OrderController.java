package com.lambdaschool.javaordersmaster.controllers;

import com.lambdaschool.javaordersmaster.models.Order;
import com.lambdaschool.javaordersmaster.services.OrderServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderServices orderServices;

    // http://localhost:2019/orders/order/7
    @GetMapping(value = "/order/{orderid}", produces = "application/json")
    public ResponseEntity<?> findById(@PathVariable long orderid)
    {
        Order c = orderServices.findById(orderid);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }

    @PostMapping(value = "/order", produces = "application/json", consumes = "application/json")
    public ResponseEntity<?> addNeworder(@RequestBody @Valid Order order)
    {
        order.setOrdnum(0);

        Order neworder = orderServices.save(order);

        HttpHeaders responseHeaders = new HttpHeaders();
        URI neworderURI = ServletUriComponentsBuilder.fromCurrentRequest().path("/{orderid}").buildAndExpand(neworder.getOrdnum()).toUri();

        responseHeaders.setLocation(neworderURI);

        return new ResponseEntity<>(neworder, responseHeaders, HttpStatus.CREATED);

    }

    // localhost:2019/orders/order/{ordernum}
    @DeleteMapping(value = "/order/{orderid}")
    public ResponseEntity<?> deleteById(@PathVariable long orderid) {
        orderServices.delete(orderid);
        return new ResponseEntity<>(HttpStatus.OK);
    }
// PUT /orders/order/{ordernum} - completely replaces the given order record

}

