package com.example.employee.controller;

import com.example.employee.model.Employee;
import com.example.employee.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public String getEmployees(Model model) throws Exception {
        System.out.println("Get employees...");
        List<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("employees", employees);
        System.out.println("Loaded employees: " + employees.size());
        return "employees"; // tên file HTML trong thư mục templates (employees.html)
    }
}
