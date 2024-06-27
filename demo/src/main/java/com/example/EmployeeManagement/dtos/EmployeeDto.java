package com.example.EmployeeManagement.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class EmployeeDto {

    @NotBlank
    private String first_name;


    @NotBlank
    private String last_name;


    @NotBlank
    @Size(max=11)
    private String phone;


    @NotBlank
    @Size(max=11)
    private String document;


    @NotBlank
    @Email
    private String email;


    @NotBlank
    private String address;

}
