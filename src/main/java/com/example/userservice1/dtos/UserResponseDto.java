package com.example.userservice1.dtos;

import com.example.userservice1.models.Role;
import com.example.userservice1.models.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Optional;

@Getter
@Setter

public class UserResponseDto {
    private Optional<String> name;
    private Optional<String> email;
    private Optional<List<Role>> roleList;

    // Getter and Setter for name
    public Optional<String> getName() {
        return name;
    }

    public void setName(Optional<String> name) {
        this.name = name;
    }

    // Getter and Setter for email
    public Optional<String> getEmail() {
        return email;
    }

    public void setEmail(Optional<String> email) {
        this.email = email;
    }

    // Getter and Setter for roleList
    public Optional<List<Role>> getRoleList() {
        return roleList;
    }

    public void setRoleList(Optional<List<Role>> roleList) {
        this.roleList = roleList;
    }

    public static UserResponseDto fromUser(User user) {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setName(Optional.ofNullable(String.valueOf(user.getName())));
        userResponseDto.setEmail(Optional.ofNullable(user.getEmail()));
        userResponseDto.setRoleList(Optional.ofNullable(user.getRoles()));
        return userResponseDto;
    }

}
