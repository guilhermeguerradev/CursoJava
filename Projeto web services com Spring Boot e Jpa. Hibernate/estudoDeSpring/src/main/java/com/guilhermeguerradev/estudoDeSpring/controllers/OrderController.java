package com.guilhermeguerradev.estudoDeSpring.controllers;

import com.guilhermeguerradev.estudoDeSpring.entities.Order;
import com.guilhermeguerradev.estudoDeSpring.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {

    @Autowired
    private OrderService service;


    @GetMapping
    public ResponseEntity<List<Order>> findAll () {
        List<Order> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping ( value = "/{id}")
    public ResponseEntity<Optional<Order>> findById(@PathVariable Long id) {
        Optional<Order> obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
