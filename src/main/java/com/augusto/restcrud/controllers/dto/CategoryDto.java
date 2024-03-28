package com.augusto.restcrud.controllers.dto;

import java.util.ArrayList;
import java.util.List;

import com.augusto.restcrud.models.Product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryDto {

    private Long id;
    private String name;
    private List<Product> productList = new ArrayList<>();

}
