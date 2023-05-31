package com.example.shopmanagerment.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String fullName;
    private String address;
    private String email;
    private Date birthday;
    private String username;
    private String password;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "role_id")
    private Role role;
}
