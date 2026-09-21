package org.hm.dto;

import lombok.Builder;

@Builder
public record RoleDto(
        Long id,
        String code,
        String libelle
) {
}