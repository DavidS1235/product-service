package com.ds.productservice.repository;

import com.ds.productservice.document.SubTypeProduct;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubTypeProductRepository extends ReactiveMongoRepository<SubTypeProduct, String> {
}
