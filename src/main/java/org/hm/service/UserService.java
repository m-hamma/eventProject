package org.hm.service;

import lombok.RequiredArgsConstructor;
import org.hm.dto.UserDto;
import org.hm.mapper.UserMapper;
import org.hm.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public List<UserDto> findAll() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDto)
                .toList();
    }

    public UserDto findById(Long id) {
        return userRepository.findById(id)
                .map(userMapper::toDto)
                .orElseThrow(() ->
                        new RuntimeException("User not found: " + id));
    }
}