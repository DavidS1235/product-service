package com.ds.productservice.document;

import java.lang.reflect.Type;
import java.util.Date;
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

    private Date date;

    private TypeProduct typeProduct;

    public SubTypeProduct(String code, String name, TypeProduct typeProduct) {
        this.code = code;
        this.name = name;
        this.typeProduct=typeProduct;

    }
}
