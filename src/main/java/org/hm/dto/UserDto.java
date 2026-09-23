package org.hm.dto;

import lombok.Builder;

@Builder
public record UserDto(
        Long id,
        String userName,
        String role,
        Boolean enabled
) {
}