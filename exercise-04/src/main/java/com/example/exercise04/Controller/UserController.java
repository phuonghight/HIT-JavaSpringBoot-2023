package com.example.exercise04.Controller;

import com.example.exercise04.User;
import com.example.exercise04.store.UsersStore;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class UserController {
    private UsersStore list = new UsersStore();

    @RequestMapping(value = "/login")
    public ModelAndView loginView() {
        ModelAndView view = new ModelAndView("login");
        return  view;
    }

    @RequestMapping(value = "/register")
    public ModelAndView registerView() {
        ModelAndView view = new ModelAndView("register");
        return  view;
    }

    @RequestMapping(value = "/store")
    public ModelAndView storeView() {
        ModelAndView view = new ModelAndView("store");
        return  view;
    }

    @PostMapping("/store")
    public ModelAndView signinHandler(Model model, @RequestParam("username") String username,
                                      @RequestParam("password") String password) {
        ModelAndView view;

        for(User user : list.getUsers()) {
            if(username.equals(user.getUsername()) && password.equals(user.getPassword())) {
                model.addAttribute("users", list.getUsers());
                view = storeView();
                return view;
            }
        }
        view = new ModelAndView("errorr");
        return view;
    }

    @GetMapping(value = "/api/users")
    public ResponseEntity<?> createAccount(@RequestBody User user) {
        return ResponseEntity.ok().body(list.getUsers());
    }

//    @GetMapping(value = "/register")
//    public ModelAndView signupHandler(@ModelAttribute User user) {
//        ModelAndView view = loginView();
//        return view;
//    }
}
