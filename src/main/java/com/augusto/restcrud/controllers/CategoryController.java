package com.augusto.restcrud.controllers;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {
        List<CategoryDto> categoryList = categoryService.findAll()
            .stream()
            .map(category -> CategoryDto.builder()
                    .id(category.getId())
                    .name(category.getName())
                    .productList(category.getProductList())
                    .build())
            .toList();
        return ResponseEntity.ok(categoryList);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody CategoryDto categoryDto) throws URISyntaxException {
        if (categoryDto.getName().isBlank()) {
            return ResponseEntity.badRequest().build();
        }

        categoryService.save(Category.builder()
            .name(categoryDto.getName())
            .build());
        
        return ResponseEntity.created(new URI("/api/category/save")).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateCategory(@PathVariable Long id, @RequestBody CategoryDto categoryDto) {

        Optional<Category> categoryOptional = categoryService.findById(id);

        if (categoryOptional.isPresent()) {
            Category category = categoryOptional.get();
            category.setName(categoryDto.getName());
            categoryService.save(category);
            return ResponseEntity.ok("Category updated");
        }

        return ResponseEntity.notFound().build();

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        
        if (id != null) {
            categoryService.deleteById(id);
            return ResponseEntity.ok("Category deleted");
        }

        return ResponseEntity.badRequest().build();

    }
}
