package com.app.controller;

import com.app.model.User;
import com.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class UserController{
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/users")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        String status = userService.upsert(user);
        return new ResponseEntity<>(status, HttpStatus.CREATED);
    }
    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable Integer id){
        User user = userService.getById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> allUsers = userService.getAllUsers();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }
    @PutMapping("/users")
    public ResponseEntity<String> updateUser(@RequestBody User user) {
        String status = userService.upsert(user);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }
    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer id){
        String status = userService.deleteById(id);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }
}
