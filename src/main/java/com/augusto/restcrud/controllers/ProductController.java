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

import com.augusto.restcrud.controllers.dto.ProductDto;
import com.augusto.restcrud.models.Product;
import com.augusto.restcrud.service.IProductService;

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

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {
        List<ProductDto> productList = productService.findAll()
        .stream()
        .map(product -> ProductDto.builder()
            .id(product.getId())
            .name(product.getName())
            .price(product.getPrice())
            .category(product.getCategory())
            .build())
        .toList();
        return ResponseEntity.ok(productList);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody ProductDto productDto) throws URISyntaxException {
        if (productDto.getName().isBlank() || productDto.getPrice() == null || productDto.getCategory() == null) {
            return ResponseEntity.badRequest().build();
        }

        Product product = Product.builder()
            .name(productDto.getName())
            .price(productDto.getPrice())
            .category(productDto.getCategory())
            .build();

        productService.save(product);

        return ResponseEntity.created(new URI("/api/product/save")).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable Long id, @RequestBody ProductDto productDto) {
        Optional<Product> productOptional = productService.findById(id);

        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            product.setName(productDto.getName());
            product.setPrice(productDto.getPrice());
            product.setCategory(productDto.getCategory());
            productService.save(product);

            return ResponseEntity.ok("Product Updated");
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        if (id != null) {
            productService.deleteById(id);
            return ResponseEntity.ok("Product deleted");
        }

        return ResponseEntity.badRequest().build();
    }
}
