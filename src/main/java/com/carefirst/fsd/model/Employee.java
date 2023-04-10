package com.carefirst.fsd.model;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "employee")
public class Employee {
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String emailAddress;
    @Column
    private String phone;
    @Column
    private String birthDate;
    @Column
    private String jobTitle;
    @Column
    private String department;
    @Column
    private String location;
    @Column
    private String startDate;
    @Id
    @GeneratedValue
    private int empolyeeId;
    @Column
    private String ManagerReporting;

    public Employee() {
    }

    public Employee(String firstName, String lastName, String emailAddress, String phone, String birthDate, String jobTitle, String department, String location, String startDate, int empolyeeId, String managerReporting) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.phone = phone;
        this.birthDate = birthDate;
        this.jobTitle = jobTitle;
        this.department = department;
        this.location = location;
        this.startDate = startDate;
        this.empolyeeId = empolyeeId;
        ManagerReporting = managerReporting;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public int getEmpolyeeId() {
        return empolyeeId;
    }

    public void setEmpolyeeId(int empolyeeId) {
        this.empolyeeId = empolyeeId;
    }

    public String getManagerReporting() {
        return ManagerReporting;
    }

    public void setManagerReporting(String managerReporting) {
        ManagerReporting = managerReporting;
    }
}