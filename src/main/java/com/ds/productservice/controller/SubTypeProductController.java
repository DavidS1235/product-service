package com.ds.productservice.controller;

import com.ds.productservice.business.service.SubTypeProductService;
import com.ds.productservice.document.SubTypeProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class SubTypeProductController {

    @Autowired
    private SubTypeProductService subTypeProductService;


    @GetMapping("/liststp")
    public Mono<ResponseEntity<Flux<SubTypeProduct>>> listSubTypes(){
        return Mono.just(ResponseEntity.ok()
                .body(subTypeProductService.listSubTypeProducts()));
    }
}
