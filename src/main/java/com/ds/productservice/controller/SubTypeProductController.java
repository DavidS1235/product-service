package com.ds.productservice.controller;

import com.ds.productservice.business.service.SubTypeProductService;
import com.ds.productservice.document.SubTypeProduct;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/subTypeProduct")
public class SubTypeProductController {

  @Autowired
  private SubTypeProductService subTypeProductService;


  @CircuitBreaker(name = "product")
  @GetMapping("")
  public Mono<ResponseEntity<Flux<SubTypeProduct>>> findAll() {
    return Mono.just(ResponseEntity.ok()
            .body(subTypeProductService.findAllSubTypeProduct()));
  }

  @CircuitBreaker(name = "product")
  @GetMapping("/{id}")
  public Mono<ResponseEntity<SubTypeProduct>> findById(@PathVariable String id) {
    return subTypeProductService.find(id)
            .map(p -> ResponseEntity.ok()
                    .body(p))
            .defaultIfEmpty(ResponseEntity.notFound().build()); //404
  }

  @CircuitBreaker(name = "product")
  @PostMapping("")
  public Mono<ResponseEntity<SubTypeProduct>> create(@RequestBody SubTypeProduct stp) {
    return subTypeProductService.saveSubTypeProduct(stp)
            .map(p -> ResponseEntity.created(URI.create("/api/subTypeProduct/".concat(p.getId())))
                    .body(p)
            );
  }

  @CircuitBreaker(name = "product")
  @PutMapping("/{id}")
  public Mono<ResponseEntity<SubTypeProduct>> update(@RequestBody SubTypeProduct stp, @PathVariable String id) {
    return subTypeProductService.find(id)
            .flatMap(sub -> {
              sub.setCode(stp.getCode());
              sub.setName(stp.getName());
              sub.setDate(stp.getDate());
              sub.setTypeProduct(stp.getTypeProduct());
              return subTypeProductService.saveSubTypeProduct(sub);
            })
            .map(p -> ResponseEntity.created(URI.create("/api/subTypeProduct/".concat(p.getId())))
                    .body(p)
            )
            .defaultIfEmpty(ResponseEntity.notFound().build());
  }

  @CircuitBreaker(name = "product")
  @DeleteMapping("/{id}")
  public Mono<ResponseEntity<Object>> delete(@PathVariable String id) {
    return subTypeProductService.find(id)
            .flatMap(stp -> {
              return subTypeProductService.DeleteSubTypeProduct(stp)
                      .then(Mono.just(ResponseEntity.noContent().build()));
            })
            .defaultIfEmpty(ResponseEntity.notFound().build());
  }


}
