package com.example.shopmanagerment.service.impl;

import com.example.shopmanagerment.model.User;
import com.example.shopmanagerment.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByUsername(username);
        if(ObjectUtils.isEmpty(user)) {
            throw new UsernameNotFoundException("Not found user with user name: " + username);
        }
        return UserDetailsImpl.map(user);
    }
}
