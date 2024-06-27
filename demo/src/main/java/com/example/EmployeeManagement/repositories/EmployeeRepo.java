package com.example.EmployeeManagement.repositories;

import com.example.EmployeeManagement.models.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmployeeRepo extends JpaRepository<EmployeeModel, UUID> {
}
