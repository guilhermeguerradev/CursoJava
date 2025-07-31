package com.guilhermeguerradev.estudoDeSpring.repositories;

import com.guilhermeguerradev.estudoDeSpring.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
