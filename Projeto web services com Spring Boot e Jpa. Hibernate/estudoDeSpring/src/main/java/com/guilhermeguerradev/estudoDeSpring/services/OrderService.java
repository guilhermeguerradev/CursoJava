package com.guilhermeguerradev.estudoDeSpring.services;

import com.guilhermeguerradev.estudoDeSpring.entities.Order;
import com.guilhermeguerradev.estudoDeSpring.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    public List<Order> findAll() {
        return repository.findAll();
    }

    public Optional<Order> findById(Long id) {
        return repository.findById(id);
    }
}
