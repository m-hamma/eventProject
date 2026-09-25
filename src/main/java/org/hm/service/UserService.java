package org.hm.service;

import lombok.RequiredArgsConstructor;
import org.hm.dto.UserDto;
import org.hm.exception.BadCredentialsException;
import org.hm.mapper.UserMapper;
import org.hm.repositories.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public Page<UserDto> findAll(Pageable pageable) {
        return userRepository.findAll(pageable)
                .map(userMapper::toDto);
    }

    public UserDto findById(Long id) {
        return userRepository.findById(id)
                .map(userMapper::toDto)
                .orElseThrow(() ->
                        new BadCredentialsException("Identifiants invalides"));
    }
    public Optional<UserDto> findByUserName(String userName) {
        return userRepository.findByUserName(userName)
                .map(userMapper::toDto);
    }
    public Optional<UserDto> authenticate(String userName, String password) {
        return userRepository.findByUserName(userName)
                .filter(user ->
                        user.getPassword().replace("{noop}", "").equals(password))
                .map(userMapper::toDto);
    }
}