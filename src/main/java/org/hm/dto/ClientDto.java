package org.hm.dto;


public record ClientDto(
        long id,
        String code,
        String nom,
        String email,
        String telephone
) {
}
