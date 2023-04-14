package com.example.week06.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String address;

    @OneToOne
    private Phone phone;



    @OneToMany(mappedBy = "student") // tên của đối tượng có quan hệ // Fetch.LAZY: load data của
    private List<Subject> subjects;

    public Student(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public Student(String name, String address, Phone phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }
}
