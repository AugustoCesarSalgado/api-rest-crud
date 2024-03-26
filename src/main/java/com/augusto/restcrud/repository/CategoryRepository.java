package com.augusto.restcrud.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.augusto.restcrud.models.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

}
