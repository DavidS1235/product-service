package com.ds.productservice.model.mongo;


import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection ="STATUS_PRODUCT")
public class ProductStatusProduct {

    @Id
    private Integer id;
    private Integer idProduct;
    private Integer idSttusPduct;
    private Integer FlgCurrent;
    private Date FecBeginning;
    private Date FecFinnish;

}
