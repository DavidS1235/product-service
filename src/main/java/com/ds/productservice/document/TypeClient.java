package com.ds.productservice.document;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "TYPE_CLIENT")
public class TypeClient {

  private String id;
  private String code;
  private String name;
}
