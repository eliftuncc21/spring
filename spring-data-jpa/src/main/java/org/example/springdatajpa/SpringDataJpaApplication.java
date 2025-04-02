package org.example.springdatajpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"org.example"})//Entityleri görmesini sağla
@ComponentScan(basePackages = {"org.example"})//restcontroller service repository anatasyonları bul beanlari oluştur
@EnableJpaRepositories(basePackages = {"org.example"})//Jpa repositorysimni bul
public class SpringDataJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaApplication.class, args);
    }

}
