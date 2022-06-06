package com.ds.productservice.model.mongo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "PRODUCT")
public class Product {

    @Id
    private Integer id;
    private Integer idBank;
    private Integer idClient;
    private Integer idStpePduct;
    private Integer tpeCrrcy;
    private Integer idSubTypeCurrency;
    private Integer idTypeCurrency;
    private Integer idClient1;
    private Integer idBank1;

}
