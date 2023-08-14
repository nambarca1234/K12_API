package com.productk12Api.service;

import com.productk12Api.model.Employees;
import org.springframework.http.ResponseEntity;

public interface EmployeeService {
    ResponseEntity<?> getListEmployees();
    ResponseEntity<?> save(Employees employees);
    ResponseEntity<?> delete(int id);
    ResponseEntity<?> findById(int id);
    ResponseEntity<?> salesByEmployees();
}
