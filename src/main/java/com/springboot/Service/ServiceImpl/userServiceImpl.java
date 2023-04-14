package com.springboot.Service.ServiceImpl;

import com.springboot.Entity.User;
import com.springboot.Repository.UserRepository;
import com.springboot.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class userServiceImpl implements UserService{

    private UserRepository userRepository;

    @Override
    public User createUser(User user) {

        return userRepository.save(user);

    }

    @Override
    public User getUserById(int id) {

        return userRepository.findById(id).get();
    }

    @Override
    public List<User> getAllUsers() {

        List<User> users = userRepository.findAll();
        return users;

    }

    @Override
    public User updateUser(int userId, User user) {

        User existingUser = userRepository.findById(userId).get();

        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());

        User updatedUser = userRepository.save(existingUser);
        return updatedUser;
    }

    @Override
    public void deleteUser(int userId) {

        userRepository.deleteById(userId);
    }
}
