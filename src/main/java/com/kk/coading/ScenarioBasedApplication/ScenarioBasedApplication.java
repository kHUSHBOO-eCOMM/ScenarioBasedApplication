package com.kk.coading.ScenarioBasedApplication;

import com.kk.coading.ScenarioBasedApplication.model.Order;
import com.kk.coading.ScenarioBasedApplication.model.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScenarioBasedApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScenarioBasedApplication.class, args);

		Product product = new Product("1","sari","clothing",2, true, 123 );
		System.out.println(product.getProductId());
	}

}
