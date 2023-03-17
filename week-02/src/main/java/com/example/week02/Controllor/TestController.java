package com.example.week02.Controllor;

import com.example.week02.Student;
import com.example.week02.Users;
import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TestController {

    @RequestMapping
    public ModelAndView index(Model model) {
        model.addAttribute("name", "Hoang Phuong");
        Student s = new Student(1, "Phuong");
        List<Student> ds = new ArrayList<>();
        ds.add(s);
        ds.add(new Student(2, "Tien Anh"));
        ds.add(new Student(3, "Kien"));
        model.addAttribute("listStudent", ds);

        ModelAndView view = new ModelAndView("index");
        view.addObject("listStudent", ds);
        return view;
    }

//    @RequestMapping("/about")
//    public String about(@RequestParam("name") String name, @RequestParam("age") String pass, Model model) {
//
//        List<Users> users = new ArrayList<>();
//        users.add(new Users("phuong", "123"));
//        users.add(new Users("tienanh", "456"));
//        users.forEach(user -> {
//            if(user.getName().equals(name) && user.getPass().equals(pass)) {
//                model.addAttribute("name", name);
//                model.addAttribute("age", pass);
//            }
//        });
//
//        return "about";
//    }
    @RequestMapping("/about")
    public String about(@ModelAttribute Users u, Model model) {

        List<Users> users = new ArrayList<>();
        users.add(new Users("phuong", "123"));
        users.add(new Users("tienanh", "456"));

        for (int i = 0; i < users.size(); i++) {
            if (u.getName().equals(users.get(i).getName()) && u.getPass().equals(users.get(i).getPass())) {
                model.addAttribute("user", u);
                return "about";
            }
        }
        return "ErrorPage";
    }

}
