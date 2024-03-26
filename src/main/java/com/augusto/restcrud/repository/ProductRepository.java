package com.augusto.restcrud.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.augusto.restcrud.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

}
