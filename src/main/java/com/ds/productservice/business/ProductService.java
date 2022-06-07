package com.ds.productservice.business;

import com.ds.productservice.document.Product;
import reactor.core.publisher.Flux;

public interface ProductService {

    Flux<Product> listProducts();

}
