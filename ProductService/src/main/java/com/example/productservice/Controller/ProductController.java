package com.example.productservice.Controller;

import com.example.productservice.Models.Product;
import com.example.productservice.Service.FakeStoreProductService;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    private FakeStoreProductService service;
    public ProductController(FakeStoreProductService service) {
        this.service = service;
    }

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable("id") Integer id) {

        return service.getProductById(id);

    }

    @GetMapping("/products")
    public void getAllProducts() {

    }

    @PostMapping("/products")
    public void createProduct() {

    }

    @PutMapping("/products/{id}")
    public void updateProduct(@PathVariable("id") Integer id){

    }

    @DeleteMapping("/products/{id}")
    public void deleteProductById(@PathVariable("id") Integer id) {

    }

}
