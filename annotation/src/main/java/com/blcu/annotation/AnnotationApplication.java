package com.blcu.annotation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class AnnotationApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnnotationApplication.class, args);
	}

}
