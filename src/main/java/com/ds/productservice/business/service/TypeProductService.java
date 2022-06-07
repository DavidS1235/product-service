package com.ds.productservice.business.service;

import com.ds.productservice.document.TypeProduct;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TypeProductService {

    public Mono<TypeProduct> createTypeProduct(TypeProduct tp);

    public Flux<TypeProduct> findAllTypeProduct();

    public Mono<TypeProduct> find(String id);

    public Mono<Void> DeleteTypeProduct(TypeProduct tp);




}
