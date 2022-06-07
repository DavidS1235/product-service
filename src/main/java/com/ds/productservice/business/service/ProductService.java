package com.ds.productservice.business.service;

import com.ds.productservice.document.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductService {

    public Flux<Product> listProducts();



}
