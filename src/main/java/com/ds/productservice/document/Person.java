package com.ds.productservice.document;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "PERSON")
public class Person {

  private String id;
  private String idTypeDocument;
  private String document;
  private String name;
  private String paternal;
  private String maternal;
  private Integer idTpePerson;
}
