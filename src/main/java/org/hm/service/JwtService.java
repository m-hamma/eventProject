package org.hm.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import org.hm.config.AppProperties;
import org.hm.mapper.UserMapper;
import org.hm.repositories.UserRepository;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Service
public class JwtService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;
    private final AppProperties appProperties;

    public JwtService(
            UserMapper userMapper,
            UserRepository userRepository,
            AppProperties appProperties) {

        this.userMapper = userMapper;
        this.userRepository = userRepository;
        this.appProperties = appProperties;
    }

    @PostConstruct
    public void validate() {

        if (appProperties.getJwt() == null
                || appProperties.getJwt().getSecret() == null
                || appProperties.getJwt().getSecret().isBlank()) {

            throw new IllegalStateException(
                    "JWT_SECRET non défini");
        }
    }

    public long getExpiration() {
        return appProperties.getJwt().getExpiration();
    }

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
                                        + appProperties.getJwt().getExpiration()
                        )
                )
                .signWith(getSigningKey())
                .compact();
    }

    public String extractUserName(String token) {

        return Jwts.parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }

    public String extractRole(String token) {

        return Jwts.parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .get("role", String.class);
    }

    public boolean isTokenValid(String token) {

        try {
            Jwts.parser()
                    .verifyWith(getSigningKey())
                    .build()
                    .parseSignedClaims(token);

            return true;

        } catch (Exception e) {
            return false;
        }
    }

    private SecretKey getSigningKey() {

        return Keys.hmacShaKeyFor(
                appProperties.getJwt()
                        .getSecret()
                        .getBytes(StandardCharsets.UTF_8)
        );
    }
}