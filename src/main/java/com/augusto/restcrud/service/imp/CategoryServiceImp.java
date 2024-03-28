package com.augusto.restcrud.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.augusto.restcrud.models.Category;
import com.augusto.restcrud.persistence.CategoryDao;
import com.augusto.restcrud.service.ICategoryService;

@Service
public class CategoryServiceImp implements ICategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public void deleteById(Long id) {
        categoryDao.deleteById(id);
    }

    @Override
    public List<Category> findAll() {
        return categoryDao.findAll();
    }

    @Override
    public Optional<Category> findById(Long id) {
        return categoryDao.findById(id);
    }

    @Override
    public void save(Category category) {
        categoryDao.save(category);
    }
    
}
