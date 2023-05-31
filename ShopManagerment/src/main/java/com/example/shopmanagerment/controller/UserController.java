package com.example.shopmanagerment.controller;

import com.example.shopmanagerment.dto.UserDTO;
import com.example.shopmanagerment.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/api")
public class UserController {
    @Autowired
    private UserServiceImpl userServiceImpl;

    @PostMapping(value = "/user")
    public ResponseEntity<?> createNewUser(@RequestBody @Valid UserDTO userDTO, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            Map<String, String> errors= new HashMap<>();

            bindingResult.getFieldErrors().forEach(
                    error -> errors.put(error.getField(), error.getDefaultMessage())
            );

            String errorMsg= "";

            for(String key: errors.keySet()){
                errorMsg += "Error in: " + key + ", Reason: " + errors.get(key) + "\n";
            }
            return ResponseEntity.ok(errorMsg);
        }
        return ResponseEntity.ok(userServiceImpl.createNewUser(userDTO));
    }
}
