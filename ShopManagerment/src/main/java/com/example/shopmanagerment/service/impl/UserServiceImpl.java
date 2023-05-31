package com.example.shopmanagerment.service.impl;

import com.example.shopmanagerment.dto.UserDTO;
import com.example.shopmanagerment.enums.EnumRole;
import com.example.shopmanagerment.model.User;
import com.example.shopmanagerment.repository.RoleRepository;
import com.example.shopmanagerment.repository.UserRepository;
import com.example.shopmanagerment.service.UserService;
import com.example.shopmanagerment.utils.Formatter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

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
                throw new Error("Username is exist");
            }
        }

        User user = modelMapper.map(userDTO, User.class);
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setRole(roleRepository.findRoleByRoleName(EnumRole.ROLE_USER));
        user.setBirthday(Formatter.convertStringToDate(userDTO.getBirthday()));

        return userRepository.save(user);
    }
}
