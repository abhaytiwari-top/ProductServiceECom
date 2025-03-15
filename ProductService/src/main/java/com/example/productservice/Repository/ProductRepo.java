package com.example.productservice.Repository;

import com.example.productservice.Models.Category;
import com.example.productservice.Models.Product;
import com.example.productservice.Repository.Projection.ProductProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

    // writing JPA HQL Query
    @Query("select p.title, p.id from Product p where p.title =: title")
    ProductProjection getProductNameByTitle(@Param("title") String title);

    @Query("select p from Product p where p.title =: title and p.id =: id")
    Product getProductByTitleAndById(@Param("title") String title, @Param("id") Integer id);

    @Query("select p.title, p.id from Product p where p.id > id")
    List<ProductProjection> getProductNameGreaterThanIdValue(@Param("id") Integer id);
}
