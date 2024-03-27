package com.augusto.restcrud.persistence.imp;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.augusto.restcrud.models.Product;
import com.augusto.restcrud.persistence.ProductDao;
import com.augusto.restcrud.repository.ProductRepository;

@Component
public class ProductDaoImp implements ProductDao {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> findAll() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> findByPriceInRange(BigDecimal minPrice, BigDecimal maxPrice) {
        return productRepository.findProductByPriceBetween(minPrice, maxPrice);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
        
    }
    
}
