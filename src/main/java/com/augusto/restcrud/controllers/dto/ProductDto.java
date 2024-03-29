package com.augusto.restcrud.controllers.dto;

import java.math.BigDecimal;

import com.augusto.restcrud.models.Category;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto {

    private Long id;
    private String name;
    private BigDecimal price;
    private Category category;

}
