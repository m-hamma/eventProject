package org.hm.dto;

public record LoginRequest(
        String username,
        String password
) {
}