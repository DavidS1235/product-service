package com.ds.productservice.business.Impl;

import com.ds.productservice.business.service.ProductService;
import com.ds.productservice.document.Product;
import com.ds.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repository;


    @Override
    public Mono<Product> saveProduct(Product p) {
        return repository.save(p);
    }

    @Override
    public Flux<Product> findAllProduct() {
        return repository.findAll();
    }

    @Override
    public Mono<Product> find(String id) {
        return repository.findById(id);
    }

    @Override
    public Mono<Void> DeleteProduct(Product p) {
        return repository.delete(p);
    }
}
