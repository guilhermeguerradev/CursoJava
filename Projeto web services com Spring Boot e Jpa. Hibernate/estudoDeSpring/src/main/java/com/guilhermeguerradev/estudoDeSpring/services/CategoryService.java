package com.guilhermeguerradev.estudoDeSpring.services;

import com.guilhermeguerradev.estudoDeSpring.entities.Category;
import com.guilhermeguerradev.estudoDeSpring.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public List<Category> findAll() {
        return repository.findAll();
    }

    public Optional<Category> findById(Long id) {
        return repository.findById(id);
    }
}
