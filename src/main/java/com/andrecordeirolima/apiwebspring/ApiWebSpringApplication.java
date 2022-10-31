package com.andrecordeirolima.apiwebspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Spring Boot Project
 * - Spring Data JPA
 * - Spring Web
 * - H2 Database
 * - OpenFeign
 *
 * @author andrecordeirolima
 */

@EnableFeignClients
@SpringBootApplication
public class ApiWebSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiWebSpringApplication.class, args);
	}

}
