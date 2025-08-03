package com.guilhermeguerradev.estudoDeSpring.repositories;

import com.guilhermeguerradev.estudoDeSpring.entities.Product;
import com.guilhermeguerradev.estudoDeSpring.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
