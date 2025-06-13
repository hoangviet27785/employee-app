package com.example.employee.controller;

import com.example.employee.model.Employee;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.io.InputStream;
import java.util.List;

@RestController
public class EmployeeController {

    @GetMapping("/employees")
    public String getEmployees(Model model) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        InputStream inputStream = new ClassPathResource("employees.json").getInputStream();
        List<Employee> employees = mapper.readValue(inputStream, new TypeReference<List<Employee>>() {});
        model.addAttribute("employees", employees);
        return "employees"; // tên file HTML trong thư mục templates (employees.html)
    }
}
