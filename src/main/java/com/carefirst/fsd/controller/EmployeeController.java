package com.carefirst.fsd.controller;

import com.carefirst.fsd.model.Employee;
import com.carefirst.fsd.dao.EmployeeRepository;
import com.carefirst.fsd.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/")
    public List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable("prodid") int id) {
     return employeeService.getEmployee(id);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable("prodid") int id) {
       employeeService.deleteEmployee(id);
    }

    @PostMapping("/")
    public Employee createEmployee(@RequestBody Employee emp){
        return employeeService.createEmployee(emp);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@RequestBody Employee emp, @PathVariable("id") int id){
        return employeeService.updateEmployee(emp,id);
    }
}
