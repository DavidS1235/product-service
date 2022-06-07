package com.ds.productservice.document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "CLIENT")
public class Client {

    @Id
    private String id;
    private String code;
    private String name;

    private int credPers;

    private int credEmpres;

    public Client(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
