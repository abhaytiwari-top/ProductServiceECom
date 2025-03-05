package com.example.productservice.Controller;

import com.example.productservice.DTO.CreateProductResponseDTO;
import com.example.productservice.Exception.ProductNotFoundException;
import com.example.productservice.Models.Product;
import com.example.productservice.Service.FakeStoreProductService;
import com.example.productservice.Service.SelfProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private FakeStoreProductService service;
    private SelfProductService selfProductService;

    public ProductController(FakeStoreProductService service) {
        this.service = service;
    }

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable("id") Integer id) throws ProductNotFoundException {
        // validation
        if(id==10000)
        {
            throw new IllegalArgumentException("Id is not valid");
        }

        Product product = service.getProductById(id);
        //validation
        if(product==null)
        {
            throw new ProductNotFoundException("Product Not Found");
        }

        return product;

    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {

        return service.getAllProducts();

    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody CreateProductResponseDTO request) {

        Product product = new Product();

        if(request.getDescription() == null)
        {
            throw new IllegalArgumentException("Description cannot be null");
        }

        product = service.createProduct(request.getTitle(), request.getDescription(), request.getImageURL(), request.getCategory().getTitle());

        return product;

    }

    @PutMapping("/products/{id}")
    public void updateProduct(@PathVariable("id") Integer id){

    }

    @DeleteMapping("/products/{id}")
    public void deleteProductById(@PathVariable("id") Integer id) {

    }

}
