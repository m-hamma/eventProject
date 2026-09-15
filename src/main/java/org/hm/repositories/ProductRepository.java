package org.hm.repositories;


import org.hm.entities.OrderEntity;
import org.hm.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository
        extends JpaRepository<ProductEntity, Long> {
}