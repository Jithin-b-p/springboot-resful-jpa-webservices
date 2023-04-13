package com.springboot.Service;

import com.springboot.Entity.User;

public interface UserService {

    User createUser(User user);

    User getUserById(int id);
}
