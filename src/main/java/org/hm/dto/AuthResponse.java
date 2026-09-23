package org.hm.dto;

import lombok.Builder;

@Builder
public record AuthResponse(
        String token,
        String userName,
        String role
) {
}