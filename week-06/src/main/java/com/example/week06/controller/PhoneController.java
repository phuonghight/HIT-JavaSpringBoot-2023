package com.example.week06.controller;

import com.example.week06.DTO.PhoneDTO;
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
public class PhoneController {
    @Autowired
    private PhoneRepository phoneRepository;

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping(value = "/api/phones")
    public ResponseEntity<?> getAPIAllPhones() {
        return ResponseEntity.ok().body(phoneRepository.findAll());
    }

    @PostMapping(value = "/create-new-phone")
    public ResponseEntity<?> createNewPhone(@RequestBody PhoneDTO phoneDTO) {
        Student student = studentRepository.findById(phoneDTO.getStudent_id()).orElseThrow();
        Phone phone = new Phone(phoneDTO.getName(), phoneDTO.getBrand(), student);
        return ResponseEntity.ok(phoneRepository.save(phone));
    }

}
