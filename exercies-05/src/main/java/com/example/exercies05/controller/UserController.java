package com.example.exercies05.controller;

import com.example.exercies05.entity.User;
import com.example.exercies05.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserServiceImpl userServiceImpl;

    @RequestMapping(value = "/not-found")
    public String notFoundView() {
        return "not-found";
    }

    @RequestMapping(value = {"/login", "/"})
    public String loginView() {
        return "login";
    }

    @RequestMapping(value = "/register")
    public String registerView() {
        return "register";
    }

    @RequestMapping(value = "/delete/{id}")
    public String deleteView(@PathVariable Long id, Model model) {
        model.addAttribute("id", id);
        return "delete";
    }

    @RequestMapping(value = "/edit/{id}")
    public String editView(@PathVariable Long id, Model model) {
        User user = userServiceImpl.getUserById(id);
        model.addAttribute("user", user);

        return "edit";
    }

    @RequestMapping(value = "/index")
    public String index(Model model) {
        List<User> users = userServiceImpl.getAllUsers();
        if(users.isEmpty()) System.out.println("Khong co gi");
        model.addAttribute("users", users);
        return  "index";
    }

    @GetMapping(value = "/api/users")
    public ResponseEntity<?> api() {
        return ResponseEntity.ok().body(userServiceImpl.getAllUsers());
    }

    @PostMapping(value = "/login")
    public String loginHandler(@RequestParam String username, @RequestParam String password, Model model) {
        if(userServiceImpl.checkUserByUsernameAndPassword(username, password)) {
            return "redirect:/index";
        } else {
            model.addAttribute("error", "Username is not exits or bad password");
            return "login";
        }
    }

    @PostMapping(value = "/register")
    public String registerHandler(@RequestParam String fullName, @RequestParam String username, @RequestParam String password, Model model) {
        if(userServiceImpl.getUserByUsername(username) == null) {
            userServiceImpl.createUser(new User(fullName, username, password));
            return "redirect:/login";
        }
        else {
            model.addAttribute("error", "Username is exits. Please try again with another username");
            return "redirect:/register";
        }
    }

    @PostMapping(value = "/user/delete/{id}")
    public String deleteUserHandler(@PathVariable Long id) {
        userServiceImpl.deleteUserById(id);
        ResponseEntity.ok().body("Successful delete user " + id);
        return "redirect:/index";
    }

    @PostMapping(value = "/edit/{id}")
    public String editUSerHandler(@PathVariable Long id, @ModelAttribute User newUser) {
        userServiceImpl.updateUser(id, newUser);
        ResponseEntity.ok().body("Successful update user " + id);
        return "redirect:/index";
    }
}
