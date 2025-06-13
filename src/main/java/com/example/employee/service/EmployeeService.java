package com.example.employee.service;

import com.example.employee.model.Employee;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.List;

@Service
public class EmployeeService {
    public List<Employee> getAllEmployees() {
        try {
            InputStream inputStream = new ClassPathResource("employees.json").getInputStream();
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(inputStream, new TypeReference<List<Employee>>() {});
        } catch (Exception e) {
            throw new RuntimeException("Cannot read employee data", e);
        }
    }
}