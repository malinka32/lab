package com.example.lab.User;

import com.example.lab.Role.Role;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {
    public UserDto toDto(User user) {
        List<String> roleNames = user.getRoles().stream()
                .map(Role::getName)
                .collect(Collectors.toList());

        return new UserDto(user.getName(), user.getSurname(), user.getEmail(), user.getContactNumber(), roleNames);
    }
}
