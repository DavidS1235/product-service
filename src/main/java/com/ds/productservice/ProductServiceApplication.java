package com.ds.productservice;

import com.ds.productservice.business.service.SubTypeProductService;
import com.ds.productservice.business.service.TypeProductService;
import com.ds.productservice.document.SubTypeProduct;
import com.ds.productservice.document.TypeProduct;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import reactor.core.publisher.Flux;

@SpringBootApplication
public class ProductServiceApplication implements CommandLineRunner {

	private final Logger log = LoggerFactory.getLogger("ProductServiceApplication");


	@Autowired
	private SubTypeProductService subTypeProductService;

	@Autowired
	private TypeProductService typeProductService;
	@Autowired
	private ReactiveMongoTemplate mongoTemplate;

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		//mongoTemplate.dropCollection("PRODUCT").subscribe();
		mongoTemplate.dropCollection("TYPE_PRODUCT").subscribe();
		mongoTemplate.dropCollection("SUB_TYPE_PRODUCT").subscribe();


		//Product types
		TypeProduct passive = new TypeProduct("TP0001", "Pasivo");
		TypeProduct active = new TypeProduct("TP0002", "Activo");


		Flux.just(passive, active)
				.flatMap(tp -> typeProductService.saveTypeProduct(tp))
				.doOnNext(tp -> {
					log.info("TypeProduct created: "+ tp.getCode() + tp.getName());
				})
				.thenMany(
						Flux.just(
								//Passive SubProductType
								new SubTypeProduct("SP0001","Ahorro", passive),
								new SubTypeProduct("SP0002","Cuenta Corriente", passive),
								new SubTypeProduct("SP0003","Plazo Fijo", passive),

								//Active SubProductType
								new SubTypeProduct("SP0004","Credito personal", active),
								new SubTypeProduct("SP0005","Credito empresarial", active),
								new SubTypeProduct("SP0006","Tarjeta de credito Personal", active),
								new SubTypeProduct("SP0007","Tarjeta de credito Empresarial",active)
						).flatMap(sub ->{
							sub.setDate(new Date());
							return subTypeProductService.saveSubTypeProduct(sub);
						})
				)
								.subscribe(stp -> log.info("Insert -> Code: "+ stp.getCode()+ "Name: "+ stp.getName()));



	}
}
