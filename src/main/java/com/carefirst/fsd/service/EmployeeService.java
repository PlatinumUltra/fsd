package com.carefirst.fsd.service;

import com.carefirst.fsd.dao.EmployeeRepository;
import com.carefirst.fsd.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {


    private final EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }

    public Employee getEmployee( int id) {
        Optional<Employee> empData = employeeRepository.findById(id);
        return empData.orElse(null);
    }

    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }

    public Employee createEmployee(Employee emp){
        return employeeRepository.save(emp);
    }

    public Employee updateEmployee( Employee emp,int id){
        Optional<Employee> empFound = employeeRepository.findById(id);
        Employee empUpdate = null;

        if (empFound.isPresent()){
            empUpdate = empFound.get();
            empUpdate.setFirstName(emp.getFirstName());
            empUpdate.setLastName(emp.getLastName());
            empUpdate.setEmailAddress(emp.getEmailAddress());
            empUpdate.setPhone(emp.getPhone());
            empUpdate.setBirthDate(emp.getBirthDate());
            empUpdate.setJobTitle(emp.getJobTitle());
            empUpdate.setDepartment(emp.getDepartment());
            empUpdate.setLocation(emp.getLocation());
            empUpdate.setStartDate(emp.getStartDate());
            empUpdate.setManagerReporting(emp.getManagerReporting());
            employeeRepository.save(empUpdate);
        }
         else {
//             throw new ChangeSetPersister.NotFoundException
        }

        return empUpdate;
    }

}
