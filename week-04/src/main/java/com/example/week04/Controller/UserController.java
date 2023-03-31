package com.example.week04.Controller;

import com.example.week04.Exception.NotFoundException;
import com.example.week04.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    static List<User> users = new ArrayList<>();
    static {
        users.add(new User(1L, "admin1", "1"));
        users.add(new User(2L, "admin2", "1"));
        users.add(new User(3L, "admin3", "1"));
        users.add(new User(4L, "admin4", "1"));
    }

    @GetMapping(value = "/user/{id}")
    public ResponseEntity<?> getUser(@PathVariable Long id) {
        User res = null;
        for (User user : users) {
            if(user.getId().equals(id)) {
                res = user;
            }
        }
        if(res == null) throw new NotFoundException("Khong tim thay nguoi dung co id " + id, HttpStatus.NOT_FOUND);
        return ResponseEntity.ok().body(res);
    }
    @GetMapping(value = "/user")
    public ResponseEntity<?> getUser(@RequestParam(required = false, defaultValue = "admin1") String username,
                                        @RequestParam String password) {
        User res = null;
        for (User user : users) {
            if(user.getUsername().equals(username) && user.getPassword().equals(password)) {
                res = user;
            }
        }
        return ResponseEntity.ok().body(res);
    }

    @PostMapping("/body/user")
    public ResponseEntity<?> createUser(@RequestBody User user) {
        return ResponseEntity.ok().body(user);
    }

    @PostMapping("/model/user")
    public ResponseEntity<?> createUserModel(@ModelAttribute User user) {
        return ResponseEntity.ok().body(user);
    }
}
