package com.example.week_03.Controller;

import com.example.week_03.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController
public class Buoi3Controller {

//    @ResponseBody
    @GetMapping("/")
    public ResponseEntity<Student> mobile() {
        Student student = new Student("phuong", 19);
        return ResponseEntity.ok().body(student);
    }
}
