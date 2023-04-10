package com.carefirst.fsd.model;

import com.carefirst.fsd.dao.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository repTest;

    @Test
    void checkGetTest(){
        Employee emp = new Employee();
    }

}