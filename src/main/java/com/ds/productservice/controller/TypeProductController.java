package com.ds.productservice.controller;


import com.ds.productservice.business.service.TypeProductService;
import com.ds.productservice.document.TypeProduct;
import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/TypeProduct")
public class TypeProductController {

    @Autowired
    private TypeProductService typeProductService;

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

    @PostMapping()
    public Mono<ResponseEntity<TypeProduct>> create(@RequestBody TypeProduct tp) {
        return typeProductService.createTypeProduct(tp)
                .map(p -> ResponseEntity.created(URI.create("/api/TypeProduct/".concat(p.getId())))
                        .body(p)
                );
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<TypeProduct>> update(@RequestBody TypeProduct tp, @PathVariable String id){
        return typeProductService.find(id)
                .flatMap(sub -> {
                    sub.setCode(tp.getCode());
                    sub.setName(tp.getName());
                    sub.setProduct(tp.getProduct());
                    return typeProductService.createTypeProduct(tp);
                })
                .map(p -> ResponseEntity.created(URI.create("/api/TypeProduct/".concat(p.getId())))
                        .body(p)
                )
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Object>> delete(@PathVariable String id) {
        return typeProductService.find(id)
                .flatMap(tp -> {
                    return typeProductService.DeleteTypeProduct(tp)
                            .then(Mono.just(ResponseEntity.noContent().build()));
                })
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
