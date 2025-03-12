package com.example.productservice.Service;

import com.example.productservice.Models.Category;
import com.example.productservice.Models.Product;
import com.example.productservice.Repository.CategoryRepo;
import com.example.productservice.Repository.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service("SelfProductService")
public class SelfProductService implements ProductService {

    private ProductRepo productRepo;
    private CategoryRepo categoryRepo;

    public SelfProductService(ProductRepo productRepo, CategoryRepo categoryRepo) {
        this.productRepo = productRepo;
        this.categoryRepo = categoryRepo;
    }


    @Override
    public Product getProductById(Integer id) {

        Product response = productRepo.findById(id).get();
        System.out.println("Fetched Product : " + response);
        return response;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    @Override
    public Product createProduct(String title, String description, String imageURL, String catTitle) {

        // validation step
        validateInputRequest(title, description, imageURL, catTitle);

        // create Product object
        Product product = new Product();
        Category category = new Category();

        product.setTitle(title);
        product.setDescription(description);
        product.setImageURL(imageURL);
        product.setCreatedAt(new Date());
        product.setUpdatedAt(new Date());

        // check if category exists in Db
        Category existingCategory = categoryRepo.findByTitle(catTitle).get();
        // If not present
        if(existingCategory == null) {
            category.setTitle(catTitle);
        }
        product.setCategory(category);

        // Finally save to Db

        Product response = productRepo.save(product);

        return response;
    }

    private void validateInputRequest(String title, String description, String imageURL, String catTitle) {
        if(title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty");
        }
        if(description == null || description.isEmpty()) {
            throw new IllegalArgumentException("Description cannot be null or empty");
        }
        if(imageURL == null || imageURL.isEmpty()) {
            throw new IllegalArgumentException("Image URL cannot be null or empty");
        }
        if(catTitle == null || catTitle.isEmpty()) {
            throw new IllegalArgumentException("Category title cannot be null or empty");
        }
    }
}

