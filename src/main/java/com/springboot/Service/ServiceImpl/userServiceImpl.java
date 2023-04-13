package com.springboot.Service.ServiceImpl;

import com.springboot.Entity.User;
import com.springboot.Repository.UserRepository;
import com.springboot.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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
}
