package com.productk12Api.controller;

import com.productk12Api.model.Employees;
import com.productk12Api.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeesController {
    @Autowired
    private EmployeeService service;

    @GetMapping("/getall")
    private ResponseEntity<?> getAll(){
        return service.getListEmployees();
    }
    @PostMapping("/save")
    private ResponseEntity<?> save(@RequestBody Employees employees){
        return service.save(employees);
    }
    @GetMapping("/delete")
    private ResponseEntity<?> delete(@RequestParam int id){
        return service.delete(id);
    }
    @GetMapping("/salesByEmployees")
    private ResponseEntity<?> salesByEmployees(){
        return service.salesByEmployees();
    }

}
