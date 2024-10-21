package com.example.projetspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.projetspring")
public class ProjetSpringApplication {

    public static void main(String[] args) {

        SpringApplication.run(ProjetSpringApplication.class, args);
    }


}
