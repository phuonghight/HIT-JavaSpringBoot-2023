package com.example.week06.controller;

import com.example.week06.DTO.StudentDTO;
import com.example.week06.entity.Phone;
import com.example.week06.entity.Student;
import com.example.week06.repository.PhoneRepository;
import com.example.week06.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private PhoneRepository phoneRepository;

    @GetMapping("/api/students")
    public ResponseEntity<?> getAllStudents() {
        return ResponseEntity.ok().body(studentRepository.findAll());
    }

    @PostMapping("/create-new-student")
    public ResponseEntity<?> createNewStudent(@RequestBody StudentDTO studentDTO) {
        Phone phone = phoneRepository.findById(studentDTO.getPhone_id()).orElseThrow();
        Student student = new Student(studentDTO.getName(), studentDTO.getAddress(), phone);

        return ResponseEntity.ok(studentRepository.save(student));
    }
}
