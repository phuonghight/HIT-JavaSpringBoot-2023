package com.example.week02.Controllor;

import com.example.week02.Student;
import com.example.week02.Account;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TestController {

    @RequestMapping
    public ModelAndView index(Model model) {
        ModelAndView view = new ModelAndView("index");

//        Student s = new Student("001", "Phuong", 19, "khmt");
//        List<Student> ds = new ArrayList<>();
//        ds.add(s);
//        model.addAttribute("listStudent", ds);
//        view.addObject("listStudent", ds);

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


    @RequestMapping("/About")
    public String about(@ModelAttribute Account a, Model model) {
        System.out.println(a.toString());
        List<Account> accountsList = new ArrayList<>();
        accountsList.add(new Account("phuong", "123"));
        accountsList.add(new Account("tienanh", "456"));
        accountsList.add(new Account("kien", "789"));

        List<Student> studentsList = new ArrayList<>();
        studentsList.add(new Student("msv01", "nguyen van a", 20, "cntt"));
        studentsList.add(new Student("msv02", "nguyen van b", 20, "cntt"));
        studentsList.add(new Student("msv03", "nguyen van c", 20, "cntt"));
        for (Account account : accountsList) {
            if (a.getName().equals(account.getName()) && a.getPass().equals(account.getPass())) {
                model.addAttribute("students", studentsList);
                return "About";
            }
        }
        return "ErrorPage";
    }
}
