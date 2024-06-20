package org.blitmatthew.repository;

import org.blitmatthew.database.DatabaseConnection;
import org.blitmatthew.entity.Employee;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class EmployeeRepository {
    private Connection connection;

    public EmployeeRepository() {
        connection = DatabaseConnection.getConnection();
    }

    public Employee save(Employee employee) {
        String sql = "INSERT INTO employee(first_name, last_name, salary, phone) VALUE(?,?,?,?)";
        try(PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, employee.getFirstName());
            statement.setString(2, employee.getLastName());
            statement.setBigDecimal(3, employee.getSalary());
            statement.setLong(4, employee.getPhone());
            int row = statement.executeUpdate();
            if(row > 0) {
                System.out.println("New Employee Added!");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return employee;
    }

    public List<Employee> findAll() {
        List<Employee> employees = new LinkedList<>();
        String sql = "SELECT * FROM employee";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setEmpId(resultSet.getLong("emp_id"));
                employee.setFirstName(resultSet.getString("first_name"));
                employee.setLastName(resultSet.getString("last_name"));
                employee.setSalary(resultSet.getBigDecimal("salary"));
                employee.setPhone(resultSet.getLong("phone"));
                employees.add(employee);
                employee = null;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return employees;
    }

    public Employee findById(Long id) {
        Employee employee;
        String sql = "SELECT * FROM employee WHERE emp_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                resultSet.next();
                employee = new Employee();
                employee.setEmpId(resultSet.getLong("emp_id"));
                employee.setFirstName(resultSet.getString("first_name"));
                employee.setLastName(resultSet.getString("last_name"));
                employee.setSalary(resultSet.getBigDecimal("salary"));
                employee.setPhone(resultSet.getLong("phone"));
            }
        } catch (SQLException e) {
            employee = null;
            System.out.println(e.getMessage());
        }
        return employee;
    }


    public void update(Employee employee) {
        String sql = "UPDATE employee SET first_name=?, last_name=?, salary=?, phone=? WHERE emp_id=?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, employee.getFirstName());
            statement.setString(2, employee.getLastName());
            statement.setBigDecimal(3, employee.getSalary());
            statement.setLong(4, employee.getPhone());
            statement.setLong(5, employee.getEmpId());

            int row = statement.executeUpdate();

            if(row > 0) {
                System.out.println("Employee updated!");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(Long id) {
        String sql = "DELETE FROM employee WHERE emp_id=?";
        try(PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, id);
            int row = statement.executeUpdate();

            if ( row > 0 ){
                System.out.println("Employee deleted!");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
