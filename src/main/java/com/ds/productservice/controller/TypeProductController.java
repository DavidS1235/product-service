package com.ds.productservice.controller;


import com.ds.productservice.business.service.TypeProductService;
import com.ds.productservice.document.TypeProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class TypeProductController {

    @Autowired
    private TypeProductService typeProductService;


    @GetMapping("/listtp")
    public Mono<ResponseEntity<Flux<TypeProduct>>> listTypes(){
        return Mono.just(ResponseEntity.ok()
                .body(typeProductService.listTypeProduct()));
    }
}
