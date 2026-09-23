package org.hm.controller.rest;

import lombok.RequiredArgsConstructor;
import org.hm.dto.AuthResponse;
import org.hm.dto.LoginRequest;
import org.hm.dto.UserDto;
import org.hm.exception.BadCredentialsException;
import org.hm.service.JwtService;
import org.hm.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
                        new BadCredentialsException(
                                "Identifiants invalides"));

        String token = jwtService.generateToken(
                user.userName(),
                user.role());

        return new AuthResponse(
                token,
                user.userName(),
                user.role());
    }
}