package com.example.EmployeeManagement.services;

import com.example.EmployeeManagement.models.EmployeeModel;
import com.example.EmployeeManagement.repositories.EmployeeRepo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    final EmployeeRepo employeeRepo;

    public EmployeeService(EmployeeRepo employeeRepo){
        this.employeeRepo = employeeRepo;
    }

    @Transactional
    public EmployeeModel save(EmployeeModel employeeModel){
        return employeeRepo.save(employeeModel);
    }
}
