package org.hm.dto;

import java.time.LocalDateTime;

public record ErrorDto(
        String code,
        String message,
        LocalDateTime timestamp) {
}