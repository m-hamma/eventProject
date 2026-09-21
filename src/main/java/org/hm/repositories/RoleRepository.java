package org.hm.repositories;

import org.hm.entities.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository
        extends JpaRepository<RoleEntity, Long> {
}