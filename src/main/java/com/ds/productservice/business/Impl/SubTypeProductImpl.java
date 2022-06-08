package com.ds.productservice.business.Impl;

import com.ds.productservice.business.service.SubTypeProductService;
import com.ds.productservice.document.SubTypeProduct;
import com.ds.productservice.repository.SubTypeProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class SubTypeProductImpl implements SubTypeProductService {

    @Autowired
    SubTypeProductRepository repository;
    @Override
    public Mono<SubTypeProduct> saveSubTypeProduct(SubTypeProduct stp) {
        return repository.save(stp);
    }

    @Override
    public Flux<SubTypeProduct> findAllSubTypeProduct() {
        return repository.findAll();
    }

    @Override
    public Mono<SubTypeProduct> find(String id) {
        return repository.findById(id);
    }
    @Override
    public Mono<Void> DeleteSubTypeProduct(SubTypeProduct stp) {return repository.delete(stp);}
}
