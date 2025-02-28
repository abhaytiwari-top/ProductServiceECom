package com.example.productservice.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductResponseDTO {

    private String title;
    private String description;
    private String imageURL;
    private CategoryResponseDTO category;

}
