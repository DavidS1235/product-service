package com.ds.productservice.model.mongo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection ="STATUS_PRODUCT")
public class StatusProduct {

    @Id
    private Integer id;
    private String code;
    private String name;
}
