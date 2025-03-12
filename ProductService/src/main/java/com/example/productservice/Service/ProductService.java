package com.example.productservice.Service;

import com.example.productservice.Models.Product;

import java.util.List;

public interface ProductService {

    public Product getProductById(Integer id);
    public List<Product> getAllProducts();
    public Product createProduct(String title, String description, String imageURL, String catTitle);

}
