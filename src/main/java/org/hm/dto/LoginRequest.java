package org.hm.dto;

public record LoginRequest(
        String userName,
        String password
) {
}