package com.example.productservice.Repository;

import com.example.productservice.Models.Category;
import com.example.productservice.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

    Optional<Product> findById(Integer id);
    Optional<Product> findByCategory(Category c);
    Optional<Product> findByIdAndCategory(Integer id, Category c);
    Optional<List<Product>> findAllByCategory(Category c);
    void deleteById(Integer id);
    void deleteAllByCategory(Category c);
    Product save(Product product);

}
