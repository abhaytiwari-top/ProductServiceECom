package com.example.productservice.Repository;

import com.example.productservice.Models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer> {

    Optional<Category> findByTitle(String title);
    Optional<Category> findById(Integer id);

}
