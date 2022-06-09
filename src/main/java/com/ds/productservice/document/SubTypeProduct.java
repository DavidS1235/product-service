package com.ds.productservice.document;

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
    private Number limitMount;
    private Number limitDay;
    private Number limitCredit;
    private Boolean commission;
    private TypeProduct typeProduct;

    public SubTypeProduct(String code, String name, Date date, Number limitMount, Number limitDay, Number limitCredit, Boolean commission, TypeProduct typeProduct) {
        this.code = code;
        this.name = name;
        this.date = date;
        this.limitMount = limitMount;
        this.limitDay = limitDay;
        this.limitCredit = limitCredit;
        this.commission = commission;
        this.typeProduct = typeProduct;
    }
}
