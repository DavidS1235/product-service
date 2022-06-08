package com.ds.productservice.controller;

import com.ds.productservice.business.service.ProductService;
import com.ds.productservice.document.Product;
import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/listp")
    public Mono<ResponseEntity<Flux<Product>>> findAll(){
        return Mono.just(ResponseEntity.ok()
                .body(productService.findAllProduct()));
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Product>> findById(@PathVariable String id) {
        return productService.find(id)
                .map(p -> ResponseEntity.ok()
                        .body(p))
                .defaultIfEmpty(ResponseEntity.notFound().build()); //404
    }

    @PostMapping("/create")
    public Mono<ResponseEntity<Product>> create(@RequestBody Product p) {
       return productService.saveProduct(p)
                .map(prd -> ResponseEntity.created(URI.create("/api/product/".concat(prd.getId())))
                        .body(prd)
                );
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<Product>> update(@RequestBody Product p, @PathVariable String id){
        return productService.find(id)
                .flatMap(prd -> {
                    prd.setIdBank(p.getIdBank());
                    prd.setTpeCrrency(p.getTpeCrrency());
                    prd.setSubTypeProduct(p.getSubTypeProduct());
                    prd.setIdClient(p.getIdClient());
                    return productService.saveProduct(p);
                })
                .map(pr -> ResponseEntity.created(URI.create("/api/product/".concat(pr.getId())))
                        .body(pr)
                )
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Object>> delete(@PathVariable String id) {
        return productService.find(id)
                .flatMap(p -> {
                    return productService.DeleteProduct(p)
                            .then(Mono.just(ResponseEntity.noContent().build()));
                })
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }





}
