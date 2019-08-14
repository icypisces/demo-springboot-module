package org.demo.springboot.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan({"org.demo.springboot.account"})
public class DemoSpringbootAccountApplication{
	
	public static void main(String[] args) {
		
		SpringApplication.run(DemoSpringbootAccountApplication.class, args);
	}

}
