package com.example.productservice.Service;

import com.example.productservice.DTO.FakeStoreResponseDTO;
import com.example.productservice.Models.Category;
import com.example.productservice.Models.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class FakeStoreProductService {

    private RestTemplate restTemplate;
    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Product getProductById(Integer id) {

        Product product = new Product();

        // http call
        ResponseEntity<FakeStoreResponseDTO> fakeStoreResponse = restTemplate.getForEntity("https://fakestoreapi.com/products/" + id, FakeStoreResponseDTO.class);

        // get the response
        FakeStoreResponseDTO response = fakeStoreResponse.getBody();
        if(response == null) {
            throw new IllegalArgumentException("FakeStore Product Not Found");
        }

        // convert response to Product Model
        product = convertFakeStoreResponseToProduct(response);

        // return
        return product;

    }

    private Product convertFakeStoreResponseToProduct(FakeStoreResponseDTO response) {
        Product product = new Product();
        Category category = new Category();

        category.setTitle(response.getCategory());
        product.setId(response.getId());
        product.setTitle(response.getTitle());
        product.setCategory(category);
        product.setDescription(response.getDescription());
        product.setImageURL(response.getImage());

        return product;
    }

    public List<Product> getAllProducts() {

        List<Product> response = new ArrayList<>();

        // http call
        ResponseEntity<FakeStoreResponseDTO[]> fakeStoreProducts = restTemplate.getForEntity("https://fakestoreapi.com/products", FakeStoreResponseDTO[].class);

        // Status Code
        System.out.println("Status Code : " + fakeStoreProducts.getStatusCode());

        if(fakeStoreProducts.getBody() == null) {
            throw new IllegalArgumentException("FakeStore Products Not Found");
        }

        // get and convert response to Product Model List<Product>
        for(FakeStoreResponseDTO fakeStoreResponseDTO : fakeStoreProducts.getBody()) {
            response.add(convertFakeStoreResponseToProduct(fakeStoreResponseDTO));
        }

        // return
        return response;

    }
}
