package org.hm.controller.rest;

import org.hm.dto.AuthResponse;
import org.hm.dto.LoginRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class LoginController {

    @GetMapping("/ping")
    public String ping() {
        return "AUTH OK";
    }

    @PostMapping("/login")
    public AuthResponse login(
            @RequestBody LoginRequest request) {

        if ("admin".equals(request.username())
                && "admin".equals(request.password())) {

            return AuthResponse.builder()
                    .token("fake-jwt-token")
                    .username("admin")
                    .role("ADMIN")
                    .build();
        }

        return null;
    }
}