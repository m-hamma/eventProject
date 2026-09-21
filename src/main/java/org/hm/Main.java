package org.hm;

import org.flywaydb.core.Flyway;
import org.hm.dto.OrderDto;
import org.hm.service.FacturationService;
import org.hm.service.OrderService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

@SpringBootApplication
public class Main {


    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    //    @Bean
//    CommandLineRunner test(OrderService orderService) {
//
//        return args -> {
//            OrderDto order = new Order(null, "ClientX");
//            orderService.createOrder(order);
//        };
//    }
    @Bean
    CommandLineRunner testFlyway() {
        return args -> {
            try {
                Class.forName("org.flywaydb.core.Flyway");
                System.out.println("Flyway class FOUND");
            } catch (Exception e) {
                System.out.println("Flyway class NOT FOUND");
            }
        };
    }
}