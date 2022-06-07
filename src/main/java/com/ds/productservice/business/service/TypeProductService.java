package com.ds.productservice.business.service;

import com.ds.productservice.document.TypeProduct;
import reactor.core.publisher.Mono;

public interface TypeProductService {

    public Mono<TypeProduct> saveTypeProduct (TypeProduct tp);
}
