package com.ds.productservice.controller;

import com.ds.productservice.business.service.ProductService;
import com.ds.productservice.business.service.SubTypeProductService;
import com.ds.productservice.business.service.TypeProductService;
import com.ds.productservice.document.Product;
import com.ds.productservice.document.SubTypeProduct;
import com.ds.productservice.document.TypeProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private SubTypeProductService subTypeProductService;

    @Autowired
    private TypeProductService typeProductService;






}
