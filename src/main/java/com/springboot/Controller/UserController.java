package com.springboot.Controller;

import com.springboot.Entity.User;
import com.springboot.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("user")
public class UserController {

    private UserService userService;

    //build create user REST API
    @PostMapping("add")
    public ResponseEntity<User> createUser(@RequestBody User user){

        User savedUser = userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    //get user by id REST API
    @GetMapping("getUser-ById/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") int id){

        User user = userService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
