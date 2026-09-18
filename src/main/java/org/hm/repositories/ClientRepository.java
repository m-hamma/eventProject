package org.hm.repositories;

import org.hm.entities.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository
        extends JpaRepository<ClientEntity, Long> {
}