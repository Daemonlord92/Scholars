package org.blitmatthew;

import org.blitmatthew.database.DatabaseConnection;
import org.blitmatthew.entity.Employee;
import org.blitmatthew.repository.EmployeeRepository;

import java.math.BigDecimal;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            if(DatabaseConnection.getConnection().isValid(30)){
                System.out.println("DATABASE CONNECTED");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        EmployeeRepository employeeRepository = new EmployeeRepository();

        //employeeRepository.save(new Employee("Jehu", "Vales", new BigDecimal("65000.00"), 9072728358L));
        System.out.println(employeeRepository.findAll());
        System.out.println(employeeRepository.findById(1l));
    }
}