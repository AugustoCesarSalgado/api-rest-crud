package com.augusto.restcrud.service.imp;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.augusto.restcrud.models.Product;
import com.augusto.restcrud.persistence.ProductDao;
import com.augusto.restcrud.service.IProductService;

@Service
public class ProductServiceImp implements IProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public void deleteById(Long id) {
        productDao.deleteById(id);        
    }

    @Override
    public List<Product> findAll() {
        return productDao.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productDao.findById(id);
    }

    @Override
    public List<Product> findByPriceInRange(BigDecimal minPrice, BigDecimal maxPrice) {
        return productDao.findByPriceInRange(minPrice, maxPrice);
    }

    @Override
    public void save(Product product) {
        productDao.save(product);        
    }
    
}
