package org.hm.dto;

import jakarta.validation.constraints.NotBlank;

public record Order(
        Long id,
        @NotBlank(message = "Le client est obligatoire")
        String customer
) {
}