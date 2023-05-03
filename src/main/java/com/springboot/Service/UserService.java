package com.springboot.Service;

import com.springboot.Dto.UserDto;
import com.springboot.Entity.User;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto userDto);

    UserDto getUserById(int id);

    List<UserDto> getAllUsers();

    UserDto updateUser(int userId, User user);

    void deleteUser(int userId);

}
