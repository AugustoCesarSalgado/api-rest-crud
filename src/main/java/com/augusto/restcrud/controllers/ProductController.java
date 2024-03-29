package com.augusto.restcrud.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.augusto.restcrud.controllers.dto.ProductDto;
import com.augusto.restcrud.models.Product;
import com.augusto.restcrud.service.IProductService;
import com.augusto.restcrud.service.imp.ProductServiceImp;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Product> productOptional = productService.findById(id);

        if (productOptional.isPresent()) {
            Product product = productOptional.get();

            ProductDto productDto = ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .category(product.getCategory())
                .build();

            return ResponseEntity.ok(productDto); 
        }

        return ResponseEntity.notFound().build();
    }
}
