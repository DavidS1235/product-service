package com.ds.productservice.business.service;

import com.ds.productservice.document.Product;
import reactor.core.publisher.Flux;

public interface ProductService {

    Flux<Product> listProducts();



}
