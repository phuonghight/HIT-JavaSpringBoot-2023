package com.example.week06.controller;

import com.example.week06.DTO.StudentDTO;
import com.example.week06.DTO.SubjectDTO;
import com.example.week06.entity.Student;
import com.example.week06.entity.Subject;
import com.example.week06.repository.StudentRepository;
import com.example.week06.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class SubjectController {
    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/api/subjects")
    public ResponseEntity<?> getAllStudents() {
        return ResponseEntity.ok().body(subjectRepository.findAll());
    }

    @PostMapping("/create-new-subject")
    public ResponseEntity<?> createNewSubject(@RequestBody SubjectDTO subjectDTO) {
        Student student = studentRepository.findById(subjectDTO.getStudent_id()).orElseThrow(() -> {
            System.out.println("Not found student with id " + subjectDTO.getStudent_id());
            return null;
        });
        Subject subject = new Subject(subjectDTO.getName(), student);

        return ResponseEntity.ok(subjectRepository.save(subject));
    }

}
