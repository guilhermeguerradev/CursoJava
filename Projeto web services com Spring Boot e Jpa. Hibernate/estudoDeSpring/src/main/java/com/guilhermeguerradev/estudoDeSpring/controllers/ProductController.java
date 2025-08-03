package com.guilhermeguerradev.estudoDeSpring.controllers;

import com.guilhermeguerradev.estudoDeSpring.entities.Product;
import com.guilhermeguerradev.estudoDeSpring.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService service;


    @RequestMapping
    public ResponseEntity<List<Product>> findAll() {
        List<Product> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @RequestMapping(value = "/{id}")
    public ResponseEntity<Optional<Product>> findById (@PathVariable Long id) {
        Optional<Product> obj = service.findById(id);
        return ResponseEntity.ok().body(obj);

    }
}
