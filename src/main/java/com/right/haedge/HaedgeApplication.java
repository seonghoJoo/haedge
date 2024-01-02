package com.right.haedge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class HaedgeApplication {

	public static void main(String[] args) {
		SpringApplication.run(HaedgeApplication.class, args);
	}

}
