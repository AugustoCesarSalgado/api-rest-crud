package com.augusto.restcrud.persistence;

import java.util.List;
import java.util.Optional;

import com.augusto.restcrud.models.Category;

public interface CategoryDao {
    
    List<Category> findAll();

    Optional<Category> findById(Long id);

    void save(Category category);

    void deleteById(Long id);

}
