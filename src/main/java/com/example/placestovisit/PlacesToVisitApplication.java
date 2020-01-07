package com.example.placestovisit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories("com.example.placestovisit.repository")
public class PlacesToVisitApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlacesToVisitApplication.class, args);
    }

}
