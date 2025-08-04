package com.guilhermeguerradev.estudoDeSpring.services;

import com.guilhermeguerradev.estudoDeSpring.entities.User;
import com.guilhermeguerradev.estudoDeSpring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public Optional<User> findById(Long id) {
        return repository.findById(id);
    }

    public User insert(User obj) {
        return repository.save(obj);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
