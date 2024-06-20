package org.blitmatthew.service;

import org.blitmatthew.dto.EmployeeDto;
import org.blitmatthew.entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee createEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(Long id);
    void updateEmployee(EmployeeDto employeeDto);
    void deleteEmployee(Long id) throws ClassNotFoundException;
}
