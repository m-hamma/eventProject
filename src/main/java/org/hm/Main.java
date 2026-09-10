package org.hm;

import org.hm.dto.Order;
import org.hm.service.FacturationService;
import org.hm.service.OrderService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Main {


    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    CommandLineRunner test(OrderService orderService) {

        return args -> {
            Order order = new Order(null, "ClientX");
            orderService.createOrder(order);
        };
    }

}