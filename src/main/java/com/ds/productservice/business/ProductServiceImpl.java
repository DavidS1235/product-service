package com.ds.productservice.business;

import com.ds.productservice.model.mongo.Product;
import com.ds.productservice.repository.ProductRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;



public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findProducts() {
        return productRepository.findAll();
    }
}
