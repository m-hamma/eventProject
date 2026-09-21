package org.hm.repositories;

import org.hm.entities.ClientEntity;
import org.hm.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository
        extends JpaRepository<UserEntity, Long> {
}