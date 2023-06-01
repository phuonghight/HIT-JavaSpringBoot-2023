package com.example.shopmanagerment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDTO {
    @NotBlank(message = "Full name is must not null!")
    private String fullName;
    @NotBlank(message = "Address is must not null!")
    private String address;
    @NotBlank(message = "Email is must not null!")
    @Pattern(regexp = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$", message = "Invalid email")
    private String email;
    @NotBlank(message = "Birthday is must not null!")
    @Pattern(regexp = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/((19|20)\\d\\d)$", message = "Invalid date")
    private String birthday;
    @NotBlank(message = "Username is must not null!")
    private String username;
    @NotBlank(message = "Password is must not null!")
    private String password;
}
