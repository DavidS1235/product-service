package com.ds.productservice.document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@Document("SUB_TYPE_PRODUCT")
public class SubTypeProduct {

    @Id
    private String id;
    private String code;
    private String name;

    public SubTypeProduct(String code, String name) {
        this.code = code;
        this.name = name;
    }
}