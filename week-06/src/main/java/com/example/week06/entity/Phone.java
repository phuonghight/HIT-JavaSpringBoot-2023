package com.example.week06.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "phone")
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String brand;

    @OneToOne(mappedBy = "phone")
    @JoinColumn(name = "student_id")
    private Student student;

    public Phone(String name, String brand, Student student) {
        this.name = name;
        this.brand = brand;
        this.student = student;
    }
}
