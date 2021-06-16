package com.dev.projetoAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class ProjetoAPIApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoAPIApplication.class, args);

	}

}
