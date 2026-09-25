package org.hm.service;

import lombok.RequiredArgsConstructor;
import org.hm.dto.RoleDto;
import org.hm.mapper.RoleMapper;
import org.hm.repositories.RoleRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    public Page<RoleDto> findAll(Pageable pageable) {
        return roleRepository.findAll(pageable)
                .map(roleMapper::toDto);
    }
    public RoleDto findById(Long id) {
        return roleRepository.findById(id)
                .map(roleMapper::toDto)
                .orElseThrow(() ->
                        new RuntimeException("Role not found: " + id));
    }
}