package com.carefirst.fsd.service;

import com.carefirst.fsd.dao.EmployeeRepository;
import com.carefirst.fsd.model.Employee;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;
    private EmployeeService employeeServiceTest;

    @BeforeEach
    void setUp() {
        employeeServiceTest = new EmployeeService(employeeRepository);
    }

    @AfterEach
    void tearDown() throws Exception {

    }

    @Test
    void CanGetAllEmployees() {
        // when
        employeeServiceTest.getEmployees();

        // then
        verify(employeeRepository).findAll();
    }

    @Test
    void getEmployee() {
        // given
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
        employee.setEmpolyeeId(5);

        // when
        employeeServiceTest.createEmployee(employee);

        // then
        verify(employeeRepository).findById(5);
    }

    @Test
    void deleteEmployee() {
        // given
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

        //when
        employeeServiceTest.deleteEmployee(employee.getEmpolyeeId());

        //then
        verify(employeeRepository).deleteById(employee.getEmpolyeeId());

    }

    @Test
    void createEmployee() {
        // given
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

        //when
        employeeServiceTest.createEmployee(employee);

        //then
        ArgumentCaptor<Employee> employeeArgumentCaptor = ArgumentCaptor.forClass(Employee.class);

        verify(employeeRepository).save(employeeArgumentCaptor.capture());

        Employee capturedEmployee = employeeArgumentCaptor.getValue();

        assertThat(capturedEmployee).isEqualTo(employee);
    }

    @Test
    void updateEmployee() {
        // given
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

        Employee employeeUpdated = new Employee();
        employeeUpdated.setFirstName("Jonny");


        //when
        employeeServiceTest.updateEmployee(employeeUpdated, employee.getEmpolyeeId());

        //then
        ArgumentCaptor<Employee> employeeArgumentCaptor = ArgumentCaptor.forClass(Employee.class);

        verify(employeeRepository).save(employeeArgumentCaptor.capture());

        Employee capturedEmployee = employeeArgumentCaptor.getValue();

        assertThat(capturedEmployee.getFirstName()).isEqualTo(employeeUpdated.getFirstName());
        assertThat(capturedEmployee.getFirstName()).isEqualTo(employee.getLastName());
    }
}