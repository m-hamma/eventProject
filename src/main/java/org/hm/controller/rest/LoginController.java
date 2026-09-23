package org.hm.controller.rest;

import lombok.RequiredArgsConstructor;
import org.hm.dto.AuthResponse;
import org.hm.dto.LoginRequest;
import org.hm.dto.UserDto;
import org.hm.service.JwtService;
import org.hm.service.UserService;
import org.springframework.web.bind.annotation.*;
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class LoginController {

    private final JwtService jwtService;
    private final UserService userService;

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest request) {

        UserDto user = userService.authenticate(
                        request.userName(),
                        request.password())
                .orElseThrow(() ->
                        new RuntimeException("Identifiants invalides"));

        String token = jwtService.generateToken(
                user.userName(),
                user.role());

        return new AuthResponse(
                token,
                user.userName(),
                user.role());
    }
}