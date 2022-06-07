package com.ds.productservice.document;

import java.util.Date;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "PRODUCT")
public class Product {

    @Id
    private String id;
    private String name;
    private TypeProduct typeProduct;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createAt;

    /*private Integer idBank;
    private Integer idClient;
    private Integer idStpePduct;
    private Integer tpeCrrcy;
    private Integer idSubTypeCurrency;
    private Integer idTypeCurrency;
    private Integer idClient1;
    private Integer idBank1;
    */

    public Product(String name, TypeProduct typeProduct, Date createAt) {
        this.name = name;
        this.typeProduct = typeProduct;
        this.createAt = createAt;
    }
}
