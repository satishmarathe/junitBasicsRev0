package com.globomantics.productservice.service;

import com.globomantics.productservice.model.Product;
import com.globomantics.productservice.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Optional<Product> findById(Integer id) {
    	System.out.println("<<<< inside ProductServiceImpl findById >>>>");
        return productRepository.findById(id);
    }   

    @Override
    public boolean delete(Integer id) {
    	System.out.println("<<<< inside ProductServiceImpl findById >>>>");
        return productRepository.delete(id);
    }
}
