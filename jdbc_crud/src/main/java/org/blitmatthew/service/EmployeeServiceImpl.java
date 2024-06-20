package org.blitmatthew.service;

import org.blitmatthew.dto.EmployeeDto;
import org.blitmatthew.entity.Employee;
import org.blitmatthew.repository.EmployeeRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class EmployeeServiceImpl implements EmployeeService{

    EmployeeRepository employeeRepository;

    public EmployeeServiceImpl() {
        this.employeeRepository = new EmployeeRepository();
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public void updateEmployee(EmployeeDto employeeDto) {
        Employee employee = employeeRepository.findById(employeeDto.id());
        if(!employee.getFirstName().equals(employeeDto.firstName()) && !Objects.equals(employeeDto.firstName(), "")) {
            employee.setFirstName(employeeDto.firstName());
        }
        if(!employee.getLastName().equals(employeeDto.lastName()) && !Objects.equals(employeeDto.lastName(), "")) {
            employee.setLastName(employeeDto.lastName());
        }
        if(!employee.getSalary().equals(employeeDto.salary())) {
            employee.setSalary(employeeDto.salary());
        }
        if(!employee.getPhone().equals(employeeDto.phone())) {
            employee.setPhone(employeeDto.phone());
        }
        employeeRepository.update(employee);
    }

    @Override
    public void deleteEmployee(Long id) throws ClassNotFoundException {
        Optional<Employee> employee = Optional.of(employeeRepository.findById(id));
        if(employee.isEmpty()) throw new ClassNotFoundException("Employee not in Database");

        employeeRepository.delete(id);
    }
}
