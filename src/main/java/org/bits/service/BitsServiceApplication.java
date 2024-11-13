package org.bits.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class BitsServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BitsServiceApplication.class, args);
    }

}
