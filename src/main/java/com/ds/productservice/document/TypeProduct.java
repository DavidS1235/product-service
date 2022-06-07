package com.ds.productservice.document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@Document("TYPE_PRODUCT")
public class TypeProduct {

    @Id
    private String id;
    private String code;
    private String name;
    private Product product;

    public TypeProduct(String code, String name, Product product) {
        this.code = code;
        this.name = name;
        this.product = product;
    }
}
