package com.example.EmployeeManagement.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;


@Getter
@Setter
@Entity
@Table(name="TB_EMPLOYEE")
public class EmployeeModel implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, length = 70)
    private String first_name;

    @Column(nullable = false, length = 70)
    private String last_name;


    @Column(nullable = false, length = 70)
    private String phone;


    @Column(nullable = false, length = 70)
    private String document;


    @Column(nullable = false, length = 70)
    private String email;

    @Column(nullable = false)
    private String registrationDate;

    @Column(nullable = false, length = 70)
    private String address;

}
