package org.hm.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.hm.dto.UserDto;
import org.hm.mapper.UserMapper;
import org.hm.repositories.UserRepository;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Optional;

@Service
public class JwtService {

    private static final String SECRET =
            "my-super-secret-key-for-event-project-authentication-2026";
    private final UserMapper userMapper;
    private final UserRepository userRepository;

    public JwtService(UserMapper userMapper, UserRepository userRepository) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
    }

    private final SecretKey key =
            Keys.hmacShaKeyFor(
                    SECRET.getBytes(StandardCharsets.UTF_8));

    public String generateToken(
            String userName,
            String role) {

        return Jwts.builder()
                .subject(userName)
                .claim("role", role)
                .issuedAt(new Date())
                .expiration(
                        new Date(
                                System.currentTimeMillis()
                                        + 86400000
                        )
                )
                .signWith(key)
                .compact();
    }

    public String extractUsername(String token) {

        return Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }

}