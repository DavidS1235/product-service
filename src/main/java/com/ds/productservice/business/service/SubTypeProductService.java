package com.ds.productservice.business.service;

import com.ds.productservice.document.Product;
import com.ds.productservice.document.SubTypeProduct;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SubTypeProductService {


    Mono<SubTypeProduct> saveSubTypeProduct (SubTypeProduct stp);

    public Flux<SubTypeProduct> listSubTypeProducts();

}
