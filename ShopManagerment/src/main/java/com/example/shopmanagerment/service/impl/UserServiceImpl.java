package com.example.shopmanagerment.service.impl;

import com.example.shopmanagerment.dto.UserDTO;
import com.example.shopmanagerment.enums.EnumRole;
import com.example.shopmanagerment.exception.AlreadyExistsException;
import com.example.shopmanagerment.exception.InternalServerException;
import com.example.shopmanagerment.exception.NotFoundException;
import com.example.shopmanagerment.model.User;
import com.example.shopmanagerment.repository.RoleRepository;
import com.example.shopmanagerment.repository.UserRepository;
import com.example.shopmanagerment.service.UserService;
import com.example.shopmanagerment.utils.Formatter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User createNewUser(UserDTO userDTO) {
        List<User> list = getAllUser();
        for(User u : list) {
            if(userDTO.getUsername().equals(u.getUsername())) {
                throw new AlreadyExistsException("Username is already exist! Please use another username!");
            } else if (u.getEmail().equals(userDTO.getEmail())) {
                throw new AlreadyExistsException("Email is already exist! Please use another email!");
            }
        }

        try {
            User user = modelMapper.map(userDTO, User.class);
            user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
            user.setRole(roleRepository.findRoleByRoleName(EnumRole.ROLE_USER));
            user.setBirthday(Formatter.convertStringToDate(userDTO.getBirthday()));

            return userRepository.save(user);
        } catch (Exception e) {
            throw new InternalServerException("Data error creating user");
        }
    }


    public User updateById(int id, UserDTO userDTO) {
        User user = getUserById(id);

        List<User> list = getAllUser();
        for(User u : list) {
            if(!user.getEmail().equals(userDTO.getEmail()) && userDTO.getUsername().equals(u.getUsername())) {
                throw new AlreadyExistsException("Username is already exist! Please use another username!");
            } else if (!user.getEmail().equals(userDTO.getEmail()) && u.getEmail().equals(userDTO.getEmail())) {
                throw new AlreadyExistsException("Email is already exist! Please use another email!");
            }
        }

        user.setFullName(userDTO.getFullName());
        user.setAddress(userDTO.getAddress());
        user.setEmail(userDTO.getEmail());
        user.setBirthday(Formatter.convertStringToDate(userDTO.getBirthday()));
        user.setUsername(userDTO.getUsername());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));

        try {
            return userRepository.save(user);
        } catch (Exception e) {
            throw new InternalServerException("Data error updating user");
        }

    }

    @Override
    public void deleteById(int id) {
        userRepository.deleteById(id);
    }

    public User getUserById(int id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty()) {
            throw new NotFoundException("Not found user with id: " + id);
        }
        return user.get();
    }

    @Override
    public List<User> getAllUser(int page, int limit) {
        if(page >= 0) {
            Page<User> users = userRepository.findAll(PageRequest.of(page, limit));
            return users.getContent();
        }
        return userRepository.findAll();
    }

    @Override
    public List<User> searchByName(String name) {
        return userRepository.findUsersByFullNameContaining(name);
    }
}
