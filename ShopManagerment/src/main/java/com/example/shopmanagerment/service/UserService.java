package com.example.shopmanagerment.service;

import com.example.shopmanagerment.dto.UserDTO;
import com.example.shopmanagerment.model.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUser();
    public User createNewUser(UserDTO userDTO);
    public User updateById(int id, UserDTO userDTO);
    public void deleteById(int id);
    public User getUserById(int id);
    public List<User> getAllUser(int page, int limit);
    public List<User> searchByName(String name);
}
