package com.augusto.restcrud.persistence;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import com.augusto.restcrud.models.Product;

public interface ProductDao {

    List<Product> findAll();

    Optional<Product> findById(Long id);

    List<Product> findByPriceInRange(BigDecimal minPrice, BigDecimal maxPrice);

    void save(Product product);

    void deleteById(Long id);

}
