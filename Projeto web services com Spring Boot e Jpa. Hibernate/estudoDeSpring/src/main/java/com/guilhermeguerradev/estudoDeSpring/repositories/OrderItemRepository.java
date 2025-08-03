package com.guilhermeguerradev.estudoDeSpring.repositories;

import com.guilhermeguerradev.estudoDeSpring.entities.OrderItem;
import com.guilhermeguerradev.estudoDeSpring.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {
}
