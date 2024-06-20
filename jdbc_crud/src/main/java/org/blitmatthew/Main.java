package org.blitmatthew;

import org.blitmatthew.database.DatabaseConnection;
import org.blitmatthew.dto.EmployeeDto;
import org.blitmatthew.entity.Employee;
import org.blitmatthew.repository.EmployeeRepository;
import org.blitmatthew.service.EmployeeService;
import org.blitmatthew.service.EmployeeServiceImpl;

import java.math.BigDecimal;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        try {
            if(DatabaseConnection.getConnection().isValid(30)){
                System.out.println("DATABASE CONNECTED");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        EmployeeRepository employeeRepository = new EmployeeRepository();
        EmployeeService employeeService = new EmployeeServiceImpl();
        employeeRepository.save(new Employee("Jehu", "Vales", new BigDecimal("65000.00"), 9072728358L));
        System.out.println(employeeRepository.findAll());
        System.out.println(employeeRepository.findById(1l));

        employeeService.updateEmployee(new EmployeeDto(1l, "Bhavani", "Kamanaboina", new BigDecimal(145000.00), 8005037834L));

        System.out.println(employeeRepository.findAll());

        //employeeService.deleteEmployee(3l);
    }
}