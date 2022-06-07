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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createAt;

    private Client client;

    /*private Integer idBank;
    private Integer idClient;
    private Integer idStpePduct;
    private Integer tpeCrrcy;
    private Integer idSubTypeCurrency;
    private Integer idTypeCurrency;
    private Integer idClient1;
    private Integer idBank1;
    */

    public Product(String name, Date createAt, Client client) {
        this.name = name;
        this.createAt = createAt;
        this.client = client;
    }
}
