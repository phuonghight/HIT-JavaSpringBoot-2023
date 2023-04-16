package com.example.week05.Controller;

import com.example.week05.User;
import com.example.week05.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/user")
    public ResponseEntity<?> createUser(@RequestBody User user) {
        return ResponseEntity.ok().body(userRepository.save(user));
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok().body(userRepository.findUserById(id));
    }

    @GetMapping("/user/{username}&{password}")
    public ResponseEntity<?> getUserByUserAndPassword(@PathVariable String username, @PathVariable String password) {
        return ResponseEntity.ok().body(userRepository.jpqlGetUser(username, password));
    }
}
