package com.springboot.Service;

import com.springboot.Entity.User;

import java.util.List;

public interface UserService {

    User createUser(User user);

    User getUserById(int id);

    List<User> getAllUsers();

    User updateUser(int userId, User user);

    void deleteUser(int userId);
}
