package com.example.lab.User;

import java.util.List;

public record UserDto(String name, String surname, String email, String contactNumber, List<String> roles) {
}
