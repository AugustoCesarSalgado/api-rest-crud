package com.augusto.restcrud.persistence;

import java.util.List;
import java.util.Optional;

import com.augusto.restcrud.models.Product;

public interface ProductDao {

    List<Product> findAll();

    Optional<Product> findById(Long id);

    void save(Product product);

    void deleteById(Long id);

}
