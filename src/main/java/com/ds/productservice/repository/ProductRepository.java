package com.ds.productservice.repository;

import com.ds.productservice.model.mongo.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, Integer> {

}
