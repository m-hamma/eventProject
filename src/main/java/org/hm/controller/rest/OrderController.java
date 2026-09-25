package org.hm.controller.rest;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestParam;
import org.hm.dto.OrderDto;
import org.hm.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createOrder(@Valid @RequestBody OrderDto order) {
        orderService.createOrder(order);
    }


    @PutMapping("/{id}")
    public void updateOrder(
            @PathVariable Long id,
            @RequestBody OrderDto order) {
        orderService.updateOrder(id, order);
    }


    @GetMapping("/{id}")
    public OrderDto getOrder(@PathVariable Long id) {
        return orderService.trouverOrdre(id);
    }

    @GetMapping
    public Page<OrderDto> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {

        return orderService.listOrders(page, size);
    }
    @GetMapping({"/ping", "/ping/", "/test"})
    public String ping() {
        return "OK";
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
    }
}
