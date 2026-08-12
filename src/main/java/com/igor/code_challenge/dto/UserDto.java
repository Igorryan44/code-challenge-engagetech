package com.igor.code_challenge.dto;

import com.igor.code_challenge.model.User;

import java.util.List;

public record UserDto(
        String name,
        String email
) {
    public static UserDto toDto(User user) {
        if (user == null){return null;}
        return new UserDto(user.getName(), user.getEmail());
    }

    public static List<UserDto> toDto(List<User> users) {
        if (users.isEmpty()) {return List.of();}
        return users.stream().map(UserDto::toDto).toList();
    }

    public static User toEntity(UserDto dto) {
        if (dto == null) {return null;}
        return new User(null, dto.name(), dto.email());
    }

    public static List<User> toEntity(List<UserDto> dtos) {
        if (dtos.isEmpty()) {return List.of();}
        return dtos.stream().map(UserDto::toEntity).toList();
    }
}
