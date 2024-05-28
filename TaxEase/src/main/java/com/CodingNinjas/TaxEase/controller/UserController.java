package com.CodingNinjas.TaxEase.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // API to fetch all users (accessible only by ADMIN role)
    @GetMapping("/all")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    // API to fetch a user by id (accessible only by NORMAL role)
    @GetMapping("/{userid}")
    @PreAuthorize("hasRole('NORMAL')")
    public ResponseEntity<User> getUserById(@PathVariable Long userid) {
        User user = userService.getUserById(userid);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    // API to sign up a new user (accessible by anyone)
    @PostMapping("/signup")
    public ResponseEntity<User> signUpUser(@RequestBody UserDto userDto) {
        User newUser = userService.createUser(userDto);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    // API to update a user by id (accessible only by NORMAL role)
    @PutMapping("/update/{id}")
    @PreAuthorize("hasRole('NORMAL')")
    public ResponseEntity<User> updateUserById(@PathVariable Long id, @RequestBody UserDto userDto) {
        User updatedUser = userService.updateUser(id, userDto);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }
}

