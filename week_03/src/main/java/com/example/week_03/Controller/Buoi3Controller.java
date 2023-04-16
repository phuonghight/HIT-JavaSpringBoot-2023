package com.example.week_03.Controller;

import com.example.week_03.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

//@Controller
@RestController
public class Buoi3Controller {

//    @ResponseBody
    @GetMapping("/api/stores")
    public ResponseEntity<Student> mobile() {
        Student student = new Student("phuong", 19);
        return ResponseEntity.ok().body(student);
    }

    @RequestMapping(value = "/")
    public ModelAndView login(Model model) {
        ModelAndView view = new ModelAndView("login");
        return view;
    }

    @RequestMapping(value = "/register")
    public ModelAndView register(Model model) {
        ModelAndView view = new ModelAndView("register");
        return view;
    }
}
