package com.ds.productservice.business;

import com.ds.productservice.model.mongo.Product;
import java.util.List;

public interface ProductService {

    List<Product> findProducts();
}
