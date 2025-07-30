package com.guilhermeguerradev.estudoDeSpring.repositories;

import com.guilhermeguerradev.estudoDeSpring.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
