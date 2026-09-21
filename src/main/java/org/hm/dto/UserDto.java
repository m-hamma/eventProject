package org.hm.dto;

import lombok.Builder;

@Builder
public record UserDto(
        Long id,
        String username,
        String role,
        Boolean enabled
) {
}