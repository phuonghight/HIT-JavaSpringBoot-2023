package com.example.exercies05.service;

import com.example.exercies05.entity.User;
import com.example.exercies05.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        if (user.getFullName() == null || user.getFullName().isEmpty()) {
            return null;
        }
        if (user.getUsername() == null || user.getUsername().isEmpty()) {
            return null;
        }
        if (user.getPassword() == null || user.getPassword().isEmpty()) {
            return null;
        }
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public  User getUserByUsername(String username) {
        return userRepository.getUserByUsername(username).orElse(null);
    }

    @Override
    public Boolean checkUserByUsernameAndPassword(String username, String password) {
        Optional<User> u = userRepository.getUserByUsernameAndPassword(username, password);
        return u.isPresent();
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User updateUser(Long id, User newUser) {
        User u = userRepository.findById(id).orElse(null);
        if (u == null) {
            return null;
        }
        u.setFullName(newUser.getFullName());
        u.setUsername(newUser.getUsername());
        u.setPassword(newUser.getPassword());
        return userRepository.save(u);
    }
}
