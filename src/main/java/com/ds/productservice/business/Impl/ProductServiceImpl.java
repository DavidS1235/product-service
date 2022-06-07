package com.ds.productservice.business.Impl;

import com.ds.productservice.business.service.ProductService;
import com.ds.productservice.document.Product;
import com.ds.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;


@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Flux<Product> listProducts() {

        return productRepository.findAll();
    }
}
