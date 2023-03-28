package com.example.exercise04.Controller;

import com.example.exercise04.User;
import com.example.exercise04.store.UsersStore;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class UserController {
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
        for(User user : UsersStore.users) {
            if(username.equals(user.getUsername()) && password.equals(user.getPassword())) {
                model.addAttribute("users", UsersStore.users);
                view = storeView();
                return view;
            }
        }
        view = new ModelAndView("errorr");
        return view;
    }

    @GetMapping(value = "/api/users")
    public ResponseEntity<?> storeAPI() {
        return ResponseEntity.ok().body(UsersStore.users);
    }

//    @PostMapping(value = "/api/users")
//    public ResponseEntity<?> createAccount(User user) {
//        UsersStore.users.add(user);
//        return ResponseEntity.ok().body(UsersStore.users);
//    }

    @PostMapping(value = "/register")
    public ModelAndView signupHandler(@ModelAttribute User user) {
        // thêm user mới đăng ký vào store
        // createAccount(user);
        UsersStore.users.add(user);

        // đăng ký xong chuyển hướng về login
        ModelAndView view = loginView();
        return view;
    }
}
