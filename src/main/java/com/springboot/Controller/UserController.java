package com.springboot.Controller;

import com.springboot.Dto.UserDto;
import com.springboot.Entity.User;
import com.springboot.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("user")
public class UserController {

    private UserService userService;

    //build create user REST API
    @PostMapping("add")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){

        UserDto savedUserDto = userService.createUser(userDto);
        return new ResponseEntity<>(savedUserDto, HttpStatus.CREATED);

    }

    //build get user by id REST API
    @GetMapping("getUser-ById/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") int id){

        UserDto userDto = userService.getUserById(id);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    //build getAll user REST API.
    @GetMapping("get-All-Users")
    public ResponseEntity<List<UserDto>> getAllUsers(){

        List<UserDto> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    //build updateUser REST API.
    @PutMapping("updateUser/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") int userId, @RequestBody User user){

        User updatedUser = userService.updateUser(userId, user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    //Build delete user REST API.
    @DeleteMapping("deleteUser/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") int userId){

        userService.deleteUser(userId);
        return new ResponseEntity<>("User successFully deleted", HttpStatus.OK);

    }
}
