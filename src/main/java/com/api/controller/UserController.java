package com.api.controller;


import com.api.model.User;
import com.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Save user to MongoDB and Elasticsearch
    @PostMapping
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    // Get user from MongoDB by ID
    @GetMapping("/{id}")
    public User getUserById(@PathVariable String id) {
        return userService.getUserById(id);
    }

    // Search users in Elasticsearch
    @GetMapping("/search")
    public Iterable<User> searchUsers(@RequestParam String query) {
        return userService.searchUsers(query);
    }

    // Delete user from MongoDB and Elasticsearch
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
    }
}
