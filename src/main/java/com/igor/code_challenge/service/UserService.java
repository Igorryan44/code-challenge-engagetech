package com.igor.code_challenge.service;

import com.igor.code_challenge.dto.UserDto;
import com.igor.code_challenge.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDto createUser(UserDto dto) {
        return UserDto.toDto(userRepository.save(UserDto.toEntity(dto)));
    }

    public List<UserDto> findAll() {
        return UserDto.toDto(userRepository.findAll());
    }

    public UserDto findById(Long id) {
        return UserDto.toDto(userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found")));
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}