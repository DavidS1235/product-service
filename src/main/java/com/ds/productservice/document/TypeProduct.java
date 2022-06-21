package com.ds.productservice.document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "TYPE_PRODUCT")
public class TypeProduct {

  @Id
  private String id;
  private String code;
  private String name;

  public TypeProduct(String code, String name) {
    this.code = code;
    this.name = name;
  }
}
