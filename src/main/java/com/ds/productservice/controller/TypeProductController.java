package com.ds.productservice.controller;


import com.ds.productservice.business.service.TypeProductService;
import com.ds.productservice.document.TypeProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class TypeProductController {

    @Autowired
    private TypeProductService typeProductService;

//
//    @PostMapping("/createtp")
//    Mono<ResponseEntity<TypeProduct>> createtp(@RequestBody TypeProduct typeProduct){
//        return typeProductService.saveTypeProduct(typeProduct);
//    }
    @GetMapping("/listtp")
    public Mono<ResponseEntity<Flux<TypeProduct>>> listTypes(){
        return Mono.just(ResponseEntity.ok()
                .body(typeProductService.findAllTypeProduct()));
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<TypeProduct>> find(@PathVariable String id) {
        return typeProductService.find(id)
                .map(p -> ResponseEntity.ok()
                        .body(p))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
