package com.example.exercies05.controller;

import com.example.exercies05.entity.User;
import com.example.exercies05.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserServiceImpl userServiceImpl;

    @RequestMapping(value = "/not-found")
    public ModelAndView notFoundView() {
        return new ModelAndView("not-found");
    }

    @RequestMapping(value = {"/login", "/"})
    public ModelAndView loginView() {
        ModelAndView view = new ModelAndView("login");
        return  view;
    }

    @RequestMapping(value = "/register")
    public ModelAndView registerView() {
        ModelAndView view = new ModelAndView("register");
        return  view;
    }

    @RequestMapping(value = "/delete/{id}")
    public ModelAndView deleteView(@PathVariable Long id) {
        ModelAndView delete = new ModelAndView("delete");
        delete.addObject("id", id);
        return delete;
    }

    @RequestMapping(value = "/edit/{id}")
    public ModelAndView editView(@PathVariable Long id) {
        User user = userServiceImpl.getUserById(id);
        ModelAndView edit = new ModelAndView("edit");
        edit.addObject("user", user);

        return edit;
    }

    @RequestMapping(value = "/index")
    public ModelAndView index() {
        ModelAndView view = new ModelAndView("index");
        List<User> users = userServiceImpl.getAllUsers();
        System.out.println(users.toString());
        view.addObject("users", users);
        return  view;
    }

    @GetMapping(value = "/api/users")
    public ResponseEntity<?> api() {
        return ResponseEntity.ok().body(userServiceImpl.getAllUsers());
    }

    @PostMapping(value = "/index")
    public ModelAndView loginHandler(@RequestParam String username, @RequestParam String password) {
        if(userServiceImpl.checkUserByUsernameAndPassword(username, password)) {
            return index();
        } else {
            ModelAndView login = new ModelAndView("login");
            login.addObject("error", "Username is not exits or bad password");
            return login;
        }
    }

    @PostMapping(value = "/register")
    public ModelAndView registerHandler(@RequestParam String fullName, @RequestParam String username, @RequestParam String password) {
        if(userServiceImpl.getUserByUsername(username) == null) {
            userServiceImpl.createUser(new User(fullName, username, password));
            return loginView();
        }
        else {
            ModelAndView register = new ModelAndView("register");
            register.addObject("errr", "Username is exits. Please try again with another username");
            return register;
        }
    }

    @PostMapping(value = "/user/delete/{id}")
    public ModelAndView deleteUserHandler(@PathVariable Long id) {
        userServiceImpl.deleteUserById(id);
        ResponseEntity.ok().body("Successful delete user " + id);
        return index();
    }

    @PostMapping(value = "/edit/{id}")
    public ModelAndView editUSerHandler(@PathVariable Long id, @ModelAttribute User newUser) {
        userServiceImpl.updateUser(id, newUser);
        ResponseEntity.ok().body("Successful update user " + id);
        return index();
    }
}
