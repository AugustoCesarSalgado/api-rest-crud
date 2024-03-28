package com.augusto.restcrud.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.augusto.restcrud.controllers.dto.CategoryDto;
import com.augusto.restcrud.models.Category;
import com.augusto.restcrud.service.ICategoryService;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Category> categoryOptional = categoryService.findById(id);

        if (categoryOptional.isPresent()) {
            Category category = categoryOptional.get();

            CategoryDto categoryDto = CategoryDto.builder()
                .id(category.getId())
                .name(category.getName())
                .productList(category.getProductList())
                .build();
            
            return ResponseEntity.ok(categoryDto);
        }

        return ResponseEntity.notFound().build();
    }
}
