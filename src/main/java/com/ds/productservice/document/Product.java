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

    private SubTypeProduct subTypeProduct;
    private String idClient;

    /*private Integer idBank;
    private Integer idClient;
    private Integer idStpePduct;
    private Integer tpeCrrcy;
    private Integer idSubTypeCurrency;
    private Integer idTypeCurrency;
    private Integer idClient1;
    private Integer idBank1;
    */

    public Product(String idBank, String tpeCrrency, SubTypeProduct subTypeProduct, String idClient) {
        this.idBank = idBank;
        this.tpeCrrency = tpeCrrency;
        this.subTypeProduct = subTypeProduct;
        this.idClient = idClient;
    }
}
