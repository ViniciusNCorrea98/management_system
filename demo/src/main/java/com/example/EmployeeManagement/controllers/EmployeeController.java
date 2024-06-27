package com.example.EmployeeManagement.controllers;


import com.example.EmployeeManagement.dtos.EmployeeDto;
import com.example.EmployeeManagement.models.EmployeeModel;
import com.example.EmployeeManagement.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/employees")
public class EmployeeController {

    final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<Object> saveEmployee(@RequestBody @Valid EmployeeDto employeeDto){
        var employeeModel = new EmployeeModel();

        BeanUtils.copyProperties(employeeDto, employeeModel);
        employeeModel.setRegistrationDate(String.valueOf(LocalDateTime.now(ZoneId.of("UTC"))));

        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.save(employeeModel));

    }



}
