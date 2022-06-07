package com.ds.productservice.repository;

import com.ds.productservice.document.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;


public interface ProductRepository extends ReactiveMongoRepository<Product, String> {

}
