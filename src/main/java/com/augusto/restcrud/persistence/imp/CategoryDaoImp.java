package com.augusto.restcrud.persistence.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.augusto.restcrud.models.Category;
import com.augusto.restcrud.persistence.CategoryDao;
import com.augusto.restcrud.repository.CategoryRepository;

@Component
public class CategoryDaoImp implements CategoryDao {

    @Autowired
    private CategoryRepository categoryRepository;
    
    @Override
    public List<Category> findAll() {
        return (List<Category>) categoryRepository.findAll();
    }
    
    @Override
    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }
    
    @Override
    public void save(Category category) {
        categoryRepository.save(category);
    }
    
    @Override
    public void deleteById(Long id) { 
        categoryRepository.deleteById(id);     
    }
    

}
