package com.ds.productservice.business.service;

import com.ds.productservice.document.TypeProduct;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TypeProductService {


    public Flux<TypeProduct> listTypeProduct();
    public Mono<TypeProduct> saveTypeProduct (TypeProduct tp);
}
