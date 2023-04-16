package com.example.exercies05.service;

import com.example.exercies05.entity.User;

import java.util.List;


public interface UserService {

    // Create
    User createUser(User user);

    // Read
    List<User> getAllUsers();
    User getUserById(Long id);
    User getUserByUsername(String username);
    Boolean checkUserByUsernameAndPassword(String username, String password);

    // Delete
    void deleteUserById(Long id);

    // Update
    User updateUser(Long id, User newUser);
}
