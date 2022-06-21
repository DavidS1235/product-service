package com.ds.productservice.document;


import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "CLIENT")
public class Client {


  private String id;
  private String code;
  private String idPerson;
  private String name;
  private Person person;
  private TypeClient typeClient;
  //Personal
  private Boolean ctaAhorro;
  private Boolean plzFijo;
  private Boolean credPersonal;
  //Personal - Empresarial
  private Integer ctaCorriente; // P: 1 E: n
  private Integer credEmpresarial; // E: n
  private Boolean tcPersonal;
  private Boolean tcEmpresarial;


}
