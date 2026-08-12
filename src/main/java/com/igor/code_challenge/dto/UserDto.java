package com.igor.code_challenge.dto;

import com.igor.code_challenge.model.User;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record UserDto(

        @NotBlank
        String name,
        @Valid
        @Email
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
        return new User(null, dto.name(), dto.email(), null);
    }

    public static List<User> toEntity(List<UserDto> dtos) {
        if (dtos.isEmpty()) {return List.of();}
        return dtos.stream().map(UserDto::toEntity).toList();
    }
}
