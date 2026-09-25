package org.hm.service;

import jakarta.transaction.Transactional;
import org.hm.dto.OrderDto;
import org.hm.entities.ClientEntity;
import org.hm.entities.OrderEntity;
import org.hm.enums.OrderStatus;
import org.hm.event.OrderCreatedEvent;
import org.hm.exception.InvoiceAttachedException;
import org.hm.exception.OrderNotFoundException;
import org.hm.mapper.ClientMapper;
import org.hm.mapper.OrderMapper;
import org.hm.repositories.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@Service
@Transactional
public class OrderService {

    private static final Logger log =
            LoggerFactory.getLogger(OrderService.class);

    private final OrderRepository orderRepository;
    private final ApplicationEventPublisher publisher;
    private final OrderMapper orderMapper;
    private final ClientMapper clientMapper;

    public OrderService(
            OrderRepository orderRepository,
            ApplicationEventPublisher publisher,
            OrderMapper orderMapper, ClientMapper clientMapper) {

        this.orderRepository = orderRepository;
        this.publisher = publisher;
        this.orderMapper = orderMapper;
        this.clientMapper = clientMapper;
    }

    public void createOrder(OrderDto order) {

        log.info("=== Début OrderService ===");

        log.info(
                "Création d'une commande pour le client {}",
                order.client().nom()
        );

        OrderEntity entity = orderMapper.toEntity(order);

        initCreation(entity);

        if (entity.getItems() != null) {
            entity.getItems().forEach(item ->
                    item.setOrder(entity));
        }

        OrderEntity saved = orderRepository.save(entity);

        log.info(
                "Commande {} enregistrée en base",
                saved.getId()
        );

        publisher.publishEvent(
                new OrderCreatedEvent(
                        saved.getId(),
                        saved.getClient().getNom()
                )
        );

        log.info("=== Fin OrderService ===");
    }

    private void initCreation(OrderEntity entity) {
        entity.setCreatedAt(LocalDateTime.now());
        entity.setUpdatedAt(LocalDateTime.now());
        entity.setStatus(OrderStatus.CREATED);
    }

    private void updateFields(
            OrderEntity entity,
            OrderDto order) {

        ClientEntity clientEntity =
                clientMapper.toEntity(order.client());

        entity.setClient(clientEntity);
        entity.setDescription(order.description());
        entity.setUpdatedAt(LocalDateTime.now());
    }

    public OrderDto trouverOrdre(Long id) {

        return orderMapper.toDto(
                orderRepository.findById(id)
                        .orElseThrow(() ->
                                new OrderNotFoundException(id))
        );
    }

    public Page<OrderDto> listOrders(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return orderRepository
                .findAll(pageable)
                .map(orderMapper::toDto);
    }


    public void deleteOrder(Long id) {

        if (!orderRepository.existsById(id)) {
            throw new OrderNotFoundException(id);
        }

        try {
            orderRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new InvoiceAttachedException();
        }
    }

    public void updateOrder(Long id, OrderDto order) {

        OrderEntity entity = orderRepository.findById(id)
                .orElseThrow(() ->
                        new OrderNotFoundException(id));

        updateFields(entity, order);
        entity.getItems().clear();
        updateItems(entity, order);

        orderRepository.save(entity);
    }

    private void updateItems(
            OrderEntity entity,
            OrderDto order) {

        entity.getItems().clear();

        OrderEntity dtoEntity = orderMapper.toEntity(order);

        if (dtoEntity.getItems() != null) {

            dtoEntity.getItems().forEach(item -> {
                item.setOrder(entity);
                entity.getItems().add(item);
            });
        }
    }
}