package com.api.service;


import com.api.model.User;
import com.api.repository.UserRepository;
import com.api.repository.UserSearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository; // MongoDB Repository

    @Autowired
    private UserSearchRepository userSearchRepository; // Elasticsearch Repository

    // Save user to MongoDB and Elasticsearch
    public User saveUser(User user) {
        // Save to MongoDB
        User savedUser = userRepository.save(user);

        // Index in Elasticsearch
        userSearchRepository.save(savedUser);

        return savedUser;
    }

    // Get user by ID from MongoDB
    public User getUserById(String id) {
        return userRepository.findById(id).orElse(null);
    }

    // Search user in Elasticsearch
    public Iterable<User> searchUsers(String query) {
        return userSearchRepository.findByNameContaining(query);
    }


    // Delete user from both MongoDB and Elasticsearch
    public void deleteUser(String id) {
        userRepository.deleteById(id);
        userSearchRepository.deleteById(id);
    }
}
