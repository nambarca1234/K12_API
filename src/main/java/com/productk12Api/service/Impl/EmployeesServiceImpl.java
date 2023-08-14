package com.productk12Api.service.Impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.productk12Api.model.BaseResponse;
import com.productk12Api.model.EmployeesDTO;
import com.productk12Api.model.Employees;
import com.productk12Api.repository.EmployeesRepository;
import com.productk12Api.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class EmployeesServiceImpl extends BaseResponse implements EmployeeService {
    @Autowired
    private EmployeesRepository employeesRepository;
    @Override
    public ResponseEntity<?> getListEmployees() {
        List<Employees> employeesList = employeesRepository.findAll();
        return getResponseEntity(employeesList);
    }

    @Override
    public ResponseEntity<?> save(Employees employees) {
        Employees employees1 = employeesRepository.save(employees);
        return getResponseEntity(employees1);
    }

    @Override
    public ResponseEntity<?> delete(int id) {
        employeesRepository.deleteById(id);
        return getResponseEntity("delete oki");
    }

    @Override
    public ResponseEntity<?> findById(int id) {
        Employees employees = employeesRepository.findById(id).get();
        return getResponseEntity(employees);
    }

    @Override
    public ResponseEntity<?> salesByEmployees() {
        List<Map<String, Object>> mapList =employeesRepository.salesByEmployees();
        ObjectMapper objectMapper = new ObjectMapper();
        List<EmployeesDTO> employeesList = new ArrayList<>();
        for (Map m: mapList) {
            EmployeesDTO employeesDTO = objectMapper.convertValue(m, EmployeesDTO.class);
            employeesList.add(employeesDTO);
        }
        return getResponseEntity(employeesList);
    }
}
