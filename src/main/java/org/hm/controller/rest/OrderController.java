package org.hm.controller.rest;

import org.hm.dto.Order;
import org.hm.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/")
    public String home() {
        return "EventProject API is running";
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createOrder(@RequestBody Order order) {
        orderService.createOrder(order);
    }

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable Long id) {
        return orderService.trouverOrdre(id);
    }
    @GetMapping
    public List<Order> listerOrders() {
        return orderService.listOrders();
    }

    @GetMapping({"/ping", "/ping/", "/test"})
    public String ping() {
        return "OK";
    }
}
