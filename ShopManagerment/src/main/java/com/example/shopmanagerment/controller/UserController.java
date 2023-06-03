package com.example.shopmanagerment.controller;

import com.example.shopmanagerment.dto.UserDTO;
import com.example.shopmanagerment.email.EmailService;
import com.example.shopmanagerment.exception.InvalidException;
import com.example.shopmanagerment.request.LoginRequest;
import com.example.shopmanagerment.respone.UserResponse;
import com.example.shopmanagerment.service.UserService;
import com.example.shopmanagerment.service.impl.UserDetailsImpl;
import com.example.shopmanagerment.utils.JwtUtils;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/api")
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping("/public/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        Authentication authentication = null;

        try {
            authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),
                    loginRequest.getPassword()));
        } catch (BadCredentialsException e) {
            log.error(e.getMessage());
        }
        SecurityContextHolder.getContext().setAuthentication(authentication);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        assert authentication != null;
        UserDetailsImpl userDetailsImpl = (UserDetailsImpl) auth.getPrincipal();
        System.out.println(userService.getUserById(userDetailsImpl.getId()));

        try {
            String accessToken = jwtUtils.generateTokenByUsername(userDetailsImpl.getUsername());
            String refreshToken = jwtUtils.generateRefreshTokenByUsername(userDetailsImpl.getUsername());
            return ResponseEntity.ok(
                    new UserResponse(userDetailsImpl.getId(), userDetailsImpl.getFullName(),
                            accessToken, refreshToken, userDetailsImpl.getAuthorities()));
        } catch (Exception e) {
            return ResponseEntity.ok("Login failed: " + e.getMessage());
        }
    }

    @PostMapping("/public/register")
    public ResponseEntity<?> createNewUser(@RequestBody @Valid UserDTO userDTO, BindingResult bindingResult) {
        propValidator(bindingResult);
        return ResponseEntity.ok(userService.createNewUser(userDTO));
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<?> updateUserById(@PathVariable int id, @RequestBody @Valid UserDTO userDTO, BindingResult bindingResult) {
        propValidator(bindingResult);
        return ResponseEntity.ok(userService.updateById(id, userDTO));
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> getUserById(@PathVariable int id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @GetMapping("/admin/search")
    public ResponseEntity<?> searchByUsername(@RequestParam String name) {
        return ResponseEntity.ok(userService.searchByName(name));
    }

    @GetMapping("/admin/filter")
    public ResponseEntity<?> getAll(@RequestParam(name = "page", required = false) int page,
                                    @RequestParam(name = "limit", required = false) int limit) {
        return ResponseEntity.ok(userService.getAllUser(page, limit));
    }

    @DeleteMapping("/admin/{id}")
    public ResponseEntity<?> deleteById(@PathVariable int id) {
        userService.deleteById(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    private void propValidator(BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            Map<String, String> errors= new HashMap<>();

            bindingResult.getFieldErrors().forEach(
                    error -> errors.put(error.getField(), error.getDefaultMessage())
            );

            String errorMsg= "";

            for(String key: errors.keySet()){
                errorMsg += "Error in: " + key + ", Reason: " + errors.get(key) + "\n";
            }

            throw new InvalidException(errorMsg);
        }
    }
}
