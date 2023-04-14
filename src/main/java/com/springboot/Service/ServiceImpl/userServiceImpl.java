package com.springboot.Service.ServiceImpl;

import com.springboot.Dto.UserDto;
import com.springboot.Entity.User;
import com.springboot.Mapper.UserMapper;
import com.springboot.Repository.UserRepository;
import com.springboot.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class userServiceImpl implements UserService{

    private UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {

        //Convert the userDto into user jpa entity.
        User user = UserMapper.mapToUser(userDto);

        User savedUser = userRepository.save(user);

        //convert the user jpa entity to userDto.
        UserDto savedUserDto = UserMapper.mapToUserDto(savedUser);

        return savedUserDto;

    }

    @Override
    public UserDto getUserById(int id) {

        User user = userRepository.findById(id).get();

        //converting user jpa entity to userDto
        UserDto userDto = UserMapper.mapToUserDto(user);

        return userDto;
    }

    @Override
    public List<UserDto> getAllUsers() {

        List<User> users = userRepository.findAll();

        return users.stream().map(UserMapper::mapToUserDto)
                .collect(Collectors.toList());

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
