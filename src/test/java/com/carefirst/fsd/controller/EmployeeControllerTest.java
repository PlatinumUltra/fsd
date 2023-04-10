package com.carefirst.fsd.controller;

import com.carefirst.fsd.model.Employee;
import com.carefirst.fsd.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(controllers = EmployeeController.class)
@ExtendWith(MockitoExtension.class)
class EmployeeControllerTest {

    @MockBean
    private EmployeeService employeeService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }


    @Test
    public void  shouldListAll() throws Exception {
        Employee employee1 = new Employee();
        employee1.setFirstName("John");
        employee1.setLastName("Doe");
        employee1.setEmailAddress("johndoe@gmail.com");
        employee1.setPhone("18001234567");
        employee1.setJobTitle("Software Dev");
        employee1.setDepartment("IT");
        employee1.setLocation("Texas");
        employee1.setStartDate("05012023");
        employee1.setManagerReporting("Robert");

        Employee employee2 = new Employee();
        employee2.setFirstName("Alex");
        employee2.setLastName("Smith");
        employee2.setEmailAddress("alexsmith@gmail.com");
        employee2.setPhone("123123123");
        employee2.setJobTitle("Accountant");
        employee2.setDepartment("Accounting");
        employee2.setLocation("Texas");
        employee2.setStartDate("05012023");
        employee2.setManagerReporting("Robert");

        Mockito.when(employeeService.getEmployees()).thenReturn(Arrays.asList(employee1,employee2));


        mockMvc.perform(MockMvcRequestBuilders.get("/employees")).
                andExpect(MockMvcResultMatchers.status().is(200));

    }

    @Test
    public void shouldCreateEmployee() throws Exception {
        Employee employee = new Employee();
        employee.setFirstName("John");
        employee.setLastName("Doe");
        employee.setEmailAddress("johndoe@gmail.com");
        employee.setPhone("18001234567");
        employee.setJobTitle("Software Dev");
        employee.setDepartment("IT");
        employee.setLocation("Texas");
        employee.setStartDate("05012023");
        employee.setManagerReporting("Robert");

        Mockito.when(employeeService.getEmployees()).thenReturn(Arrays.asList(employee));

        mockMvc.perform(MockMvcRequestBuilders.get("/employees")).
                andExpect(MockMvcResultMatchers.status().is(200));
    }



    @Test
    public void  shoulGetById() throws Exception {

        Employee employee = new Employee();
        employee.setFirstName("John");
        employee.setLastName("Doe");
        employee.setEmailAddress("johndoe@gmail.com");
        employee.setPhone("18001234567");
        employee.setJobTitle("Software Dev");
        employee.setDepartment("IT");
        employee.setLocation("Texas");
        employee.setStartDate("05012023");
        employee.setManagerReporting("Robert");

        mockMvc.perform(MockMvcRequestBuilders.get("/employees/1")).
                andExpect(MockMvcResultMatchers.jsonPath("$.firstname").value("John")).
                andExpect(MockMvcResultMatchers.status().is(200));

    }
}