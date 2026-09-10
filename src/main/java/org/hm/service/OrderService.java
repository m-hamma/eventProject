package org.hm.service;

import jakarta.transaction.Transactional;
import org.hm.dto.Order;
import org.hm.entities.OrderEntity;
import org.hm.enums.OrderStatus;
import org.hm.event.OrderCreatedEvent;
import org.hm.mapper.OrderMapper;
import org.hm.repositories.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class OrderService {

    private static final Logger log =
            LoggerFactory.getLogger(OrderService.class);
    private final OrderRepository orderRepository;
    private final ApplicationEventPublisher publisher;
    private final OrderMapper orderMapper;

    public OrderService(OrderRepository orderRepository, ApplicationEventPublisher publisher, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.publisher = publisher;
        this.orderMapper = orderMapper;
    }

    public void createOrder(Order order) {

        log.info("=== Début OrderService ===");

        log.info(
                "Création d'une commande pour le client {}",
                order.customer()
        );
        OrderEntity entity = orderMapper.toEntity(order);
        entity.setCreatedAt(LocalDateTime.now());
        entity.setStatus(OrderStatus.CREATED.name());
        OrderEntity saved = orderRepository.save(entity);

        log.info(
                "Commande {} enregistrée en base",
                saved.getId()
        );

        publisher.publishEvent(
                new OrderCreatedEvent(
                        saved.getId(),
                        order.customer()
                )
        );

        log.info("=== Fin OrderService ===");
    }

    public Order trouverOrdre(Long id) {
        return orderMapper.toDto(
                orderRepository.findById(id).get()
        );
    }

    public List<Order> listOrders() {

        List<Order> orders = new ArrayList<>();

        orderRepository.findAll().forEach(order -> {
            orders.add(orderMapper.toDto(order));
        });

        return orders;
    }
}