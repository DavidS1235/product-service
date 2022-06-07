package com.ds.productservice.business.Impl;

import com.ds.productservice.business.service.TypeProductService;
import com.ds.productservice.document.TypeProduct;
import com.ds.productservice.repository.TypeProductRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class TypeProductImpl implements TypeProductService {

    @Autowired
    TypeProductRespository repository;

    @Override
    public Mono<TypeProduct> saveTypeProduct(TypeProduct tp) {
        return repository.save(tp);
    }
}
