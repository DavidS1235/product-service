package com.ds.productservice.business.service;

import com.ds.productservice.document.Product;
import com.ds.productservice.document.SubTypeProduct;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductService {

    public Mono<Product> saveProduct(Product p);

    public Flux<Product> findAllProduct();

    public Mono<Product> find(String id);

    public Mono<Void> DeleteProduct(Product p);



}
