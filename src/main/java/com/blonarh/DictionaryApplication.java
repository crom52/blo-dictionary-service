package com.blonarh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
//@EnableJpaAuditing
//@EnableConfigurationProperties
@EnableJpaRepositories
public class DictionaryApplication {

    public static void main(String[] args) {
        SpringApplication.run(DictionaryApplication.class, args);
    }
}
