package com.ds.productservice.business.service;

import com.ds.productservice.document.Product;
import com.ds.productservice.document.SubTypeProduct;
import com.ds.productservice.document.TypeProduct;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SubTypeProductService {
    public Mono<SubTypeProduct> saveSubTypeProduct(SubTypeProduct stp);

    public Flux<SubTypeProduct> findAllSubTypeProduct();

    public Mono<SubTypeProduct> find(String id);

    public Mono<Void> DeleteSubTypeProduct(SubTypeProduct stp);



}
