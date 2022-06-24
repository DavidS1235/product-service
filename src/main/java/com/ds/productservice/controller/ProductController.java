package com.ds.productservice.controller;

import com.ds.productservice.business.service.ProductService;
import com.ds.productservice.document.Product;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/product")
public class ProductController {

  @Autowired
  private ProductService productService;

  @CircuitBreaker(name = "product")
  @GetMapping("")
  public Mono<ResponseEntity<Flux<Product>>> findAll() {
    return Mono.just(ResponseEntity.ok()
            .body(productService.findAllProduct()));
  }

  @CircuitBreaker(name = "product")
  @GetMapping("/{id}")
  public Mono<ResponseEntity<Product>> findById(@PathVariable String id) {
    return productService.find(id)
            .map(p -> ResponseEntity.ok()
                    .body(p))
            .defaultIfEmpty(ResponseEntity.notFound().build()); //404
  }

  @CircuitBreaker(name = "product")
  @PostMapping(value = "/ctaahorro"
          , consumes = MediaType.APPLICATION_JSON_VALUE,
          produces = MediaType.APPLICATION_JSON_VALUE)
  public Mono<ResponseEntity<Product>> createCtaAhorro(@RequestBody Product p) {
    return productService.saveProduct(p)
            .map(prd -> ResponseEntity.created(URI.create("/api/product/".concat(prd.getId())))
                    .body(prd)
            );
  }

  @CircuitBreaker(name = "product")
  @PostMapping(value = "/ctacorriente"
          , consumes = MediaType.APPLICATION_JSON_VALUE,
          produces = MediaType.APPLICATION_JSON_VALUE)
  public Mono<ResponseEntity<Product>> createCtaCorriente(@RequestBody Product p) {
    return productService.saveProduct(p)
            .map(prd -> ResponseEntity.created(URI.create("/api/product/".concat(prd.getId())))
                    .body(prd)
            );
  }

  @CircuitBreaker(name = "product")
  @PostMapping(value = "/pzofijo"
          , consumes = MediaType.APPLICATION_JSON_VALUE,
          produces = MediaType.APPLICATION_JSON_VALUE)
  public Mono<ResponseEntity<Product>> createPzoFijo(@RequestBody Product p) {
    return productService.saveProduct(p)
            .map(prd -> ResponseEntity.created(URI.create("/api/product/".concat(prd.getId())))
                    .body(prd)
            );
  }

  @CircuitBreaker(name = "product")
  @PostMapping(value = "/credpersonal"
          , consumes = MediaType.APPLICATION_JSON_VALUE,
          produces = MediaType.APPLICATION_JSON_VALUE)
  public Mono<ResponseEntity<Product>> createCredPersonal(@RequestBody Product p) {
    return productService.saveProduct(p)
            .map(prd -> ResponseEntity.created(URI.create("/api/product/".concat(prd.getId())))
                    .body(prd)
            );
  }

  @CircuitBreaker(name = "product")
  @PostMapping(value = "/credempresarial"
          , consumes = MediaType.APPLICATION_JSON_VALUE,
          produces = MediaType.APPLICATION_JSON_VALUE)
  public Mono<ResponseEntity<Product>> createCredEmpresarial(@RequestBody Product p) {
    return productService.saveProduct(p)
            .map(prd -> ResponseEntity.created(URI.create("/api/product/".concat(prd.getId())))
                    .body(prd)
            );
  }

  @CircuitBreaker(name = "product")
  @PostMapping(value = "/tc"
          , consumes = MediaType.APPLICATION_JSON_VALUE,
          produces = MediaType.APPLICATION_JSON_VALUE)
  public Mono<ResponseEntity<Product>> createTC(@RequestBody Product p) {
    return productService.saveProduct(p)
            .map(prd -> ResponseEntity.created(URI.create("/api/product/".concat(prd.getId())))
                    .body(prd)
            );
  }

  @CircuitBreaker(name = "product")
  @PostMapping(value = "/debitcard"
          , consumes = MediaType.APPLICATION_JSON_VALUE,
          produces = MediaType.APPLICATION_JSON_VALUE)
  public Mono<ResponseEntity<Product>> createDebitCard(@RequestBody Product p) {
    return productService.saveProduct(p)
            .map(prd -> ResponseEntity.created(URI.create("/api/product/".concat(prd.getId())))
                    .body(prd)
            );
  }

  @CircuitBreaker(name = "product")
  @PutMapping("/{id}")
  public Mono<ResponseEntity<Product>> update(@RequestBody Product p, @PathVariable String id) {
    return productService.find(id)
            .flatMap(prd -> {
              prd.setIdBank(p.getIdBank());
              prd.setTpeCrrency(p.getTpeCrrency());
              prd.setDate(p.getDate());
              prd.setSubTypeProduct(p.getSubTypeProduct());
              prd.setClient(p.getClient());
              return productService.saveProduct(prd);
            })
            .map(pr -> ResponseEntity.created(URI.create("/api/product/".concat(pr.getId())))
                    .body(pr)
            )
            .defaultIfEmpty(ResponseEntity.notFound().build());
  }

  @CircuitBreaker(name = "product")
  @PostMapping(value = "/balance/{id}",
          consumes = MediaType.APPLICATION_JSON_VALUE,
          produces = MediaType.APPLICATION_JSON_VALUE)
  public Mono<ResponseEntity<Product>> updateBalance(@RequestBody Product p, @PathVariable String id) {
    return productService.find(id)
            .flatMap(prd -> {
              prd.setNumRemainder(p.getNumRemainder());
              return productService.saveProduct(prd);
            })
            .map(pr -> ResponseEntity.created(URI.create("/api/product/".concat(pr.getId())))
                    .body(pr)
            )
            .defaultIfEmpty(ResponseEntity.notFound().build());
  }

  @CircuitBreaker(name = "product")
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
