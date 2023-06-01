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
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
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
        checkUserDto(userDTO);
        try {
            modelMapper.typeMap(UserDTO.class, User.class).addMappings(new PropertyMap<UserDTO, User>() {
                @Override
                protected void configure() {
                    skip(destination.getBirthday());
                }
            });

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
        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty()) {
            throw new NotFoundException("Not found user with id: " + id);
        }

        checkUserDto(userDTO);

        user.get().setFullName(userDTO.getFullName());
        user.get().setAddress(userDTO.getAddress());
        user.get().setEmail(userDTO.getEmail());
        user.get().setBirthday(Formatter.convertStringToDate(userDTO.getBirthday()));
        user.get().setUsername(userDTO.getUsername());
        user.get().setPassword(userDTO.getPassword());

        try {
            return userRepository.save(user.get());
        } catch (Exception e) {
            throw new InternalServerException("Data error updating user");
        }

    }

    private void checkUserDto(UserDTO userDTO) {
        List<User> list = getAllUser();
        for(User u : list) {
            if(userDTO.getUsername().equals(u.getUsername())) {
                throw new AlreadyExistsException("Username is already exist! Please use another username!");
            } else if (u.getEmail().equals(userDTO.getEmail())) {
                throw new AlreadyExistsException("Email is already exist! Please use another email!");
            }
        }
    }
}
