package com.ds.productservice.document;

import java.util.Date;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "PRODUCT")
public class Product {

    @Id
    private String id;
    private String idBank;
    private String tpeCrrency;
    private Number numRemainder;
    private Date date;
    private SubTypeProduct subTypeProduct;
    private Client client;


    public Product(String idBank, String tpeCrrency, Number numRemainder, Date date, SubTypeProduct subTypeProduct, Client client) {
        this.idBank = idBank;
        this.tpeCrrency = tpeCrrency;
        this.numRemainder = numRemainder;
        this.date = date;
        this.subTypeProduct = subTypeProduct;
        this.client = client;
    }
}
