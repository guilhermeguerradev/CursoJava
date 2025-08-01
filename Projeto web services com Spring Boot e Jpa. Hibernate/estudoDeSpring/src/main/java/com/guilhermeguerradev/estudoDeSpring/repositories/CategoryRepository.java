package com.guilhermeguerradev.estudoDeSpring.repositories;

import com.guilhermeguerradev.estudoDeSpring.entities.Category;
import com.guilhermeguerradev.estudoDeSpring.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
