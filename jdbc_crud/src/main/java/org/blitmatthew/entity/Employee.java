package org.blitmatthew.entity;

import java.math.BigDecimal;

public class Employee {
    private Long empId;
    private String firstName;
    private String lastName;
    private BigDecimal salary;
    private Long phone;

    public Employee() {
    }

    public Employee(String firstName, String lastName, BigDecimal salary, Long phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.phone = phone;
    }

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
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

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                ", phone=" + phone +
                '}';
    }
}
