package com.ds.productservice.repository;

import com.ds.productservice.document.TypeProduct;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeProductRespository extends ReactiveMongoRepository<TypeProduct, String> {
}
