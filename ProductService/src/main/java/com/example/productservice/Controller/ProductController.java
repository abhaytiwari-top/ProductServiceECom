package com.example.productservice.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @GetMapping("/products/{id}")
    public void getProductById(@PathVariable("id") Integer id) {

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
