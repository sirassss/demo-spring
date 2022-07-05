package com.anhlam.petrang;

import com.anhlam.petrang.domain.SanPham;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

@SpringBootApplication
public class PetrangApplication {

	public static void main(String[] args) {
		SpringApplication.run(PetrangApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*");
			}
		};
	}

//	@Bean
//	public EntityManager entityManager(EntityManagerFactory entityManagerFactory) {
//		return entityManagerFactory.createEntityManager();
//	}

}
