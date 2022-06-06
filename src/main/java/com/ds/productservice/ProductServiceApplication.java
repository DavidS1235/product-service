package com.ds.productservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductServiceApplication implements CommandLineRunner {

	private final Logger logger = LoggerFactory.getLogger("ProductServiceApplication");

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		logger.trace("LOGGER TRACE");
		logger.debug("LOGGER DEBUG");
		logger.info("LOGGER INFO");
		logger.warn("LOGGER WARN");
		logger.error("LOGGER ERROR");
	}
}
