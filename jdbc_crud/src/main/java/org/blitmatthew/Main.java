package org.blitmatthew;

import org.blitmatthew.database.DatabaseConnection;
import org.blitmatthew.dto.EmployeeDto;
import org.blitmatthew.entity.Employee;
import org.blitmatthew.repository.EmployeeRepository;
import org.blitmatthew.service.EmployeeService;
import org.blitmatthew.service.EmployeeServiceImpl;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

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

//        EmployeeRepository employeeRepository = new EmployeeRepository();
//        EmployeeService employeeService = new EmployeeServiceImpl();
//        employeeRepository.save(new Employee("Jehu", "Vales", new BigDecimal("65000.00"), 9072728358L));
//        System.out.println(employeeRepository.findAll());
//        System.out.println(employeeRepository.findById(1l));
//
//        employeeService.updateEmployee(new EmployeeDto(1l, "Bhavani", "Kamanaboina", new BigDecimal(145000.00), 8005037834L));
//
//        System.out.println(employeeRepository.findAll());

        //employeeService.deleteEmployee(3l);
        EmployeeService employeeService = new EmployeeServiceImpl();
        Scanner scanner = new Scanner(System.in);

        int input;

        while(true) {
            System.out.println("""
                    Welcome to the Employee Management System!!!
                    the following options are available.
                    1) Create New Employee
                    2) Get All Employees
                    3) Get Employees By ID
                    4) Update an Employee
                    5) Delete an Employee
                    6) Exit
                    """);
            input = scanner.nextInt();
            switch(input){
                case 1:
                    Employee employee = new Employee();
                    scanner.nextLine();
                    System.out.println("Please enter first name");
                    employee.setFirstName(scanner.nextLine());
                    System.out.println("Please enter last name");
                    employee.setLastName(scanner.nextLine());
                    System.out.println("Please enter starting salary");
                    employee.setSalary(new BigDecimal(scanner.nextLine()));
                    System.out.println("Please enter phone number");
                    employee.setPhone(scanner.nextLong());
                    employeeService.createEmployee(employee);
                    break;
                case 2:
                    List<Employee> employees = employeeService.getAllEmployees();
                    employees.forEach(System.out::println);
                    break;
                case 3:
                    scanner.nextLine();
                    System.out.println("Please enter employee id");
                    employee = employeeService.getEmployeeById(scanner.nextLong());
                    System.out.println(employee);
                    break;
                case 4:
                    scanner.nextLine();
                    System.out.println("Please enter employee id");
                    employee = employeeService.getEmployeeById(scanner.nextLong());
                    System.out.println("Would you like to change the first name? (Yes/No)");
                    scanner.nextLine();
                    String yN = scanner.nextLine(), newFirstName = "", newLastName = "", newSalary = "";
                    Long newPhone = 0l;
                    if(yN.equalsIgnoreCase("yes")) {
                        newFirstName = scanner.nextLine();
                    } else if (yN.equalsIgnoreCase("no")) {
                        newFirstName = employee.getFirstName();
                    }
                    System.out.println("Would you like to change the last name? (Yes/No)");
                    yN = scanner.nextLine();
                    if(yN.equalsIgnoreCase("yes")) {
                        newLastName = scanner.nextLine();
                    } else if (yN.equalsIgnoreCase("no")) {
                        newLastName = employee.getLastName();
                    }
                    System.out.println("Would you like to change the salary? (Yes/No)");
                    yN = scanner.nextLine();
                    if(yN.equalsIgnoreCase("yes")) {
                        newSalary = scanner.nextLine();
                    } else if (yN.equalsIgnoreCase("no")) {
                        newSalary = String.valueOf(employee.getSalary());
                    }
                    System.out.println("Would you like to change the phone? (Yes/No)");
                    yN = scanner.nextLine();
                    if(yN.equalsIgnoreCase("yes")) {
                        newPhone = scanner.nextLong();
                    } else if (yN.equalsIgnoreCase("no")) {
                        newPhone = employee.getPhone();
                    }

                    employeeService.updateEmployee(
                            new EmployeeDto(
                                    employee.getEmpId(),
                                    newFirstName,
                                    newLastName,
                                    new BigDecimal(newSalary),
                                    newPhone));
                    break;
                case 5:
                    scanner.nextLine();
                    System.out.println("Please enter employee id");
                    employeeService.deleteEmployee(scanner.nextLong());
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Please enter a number 1-6 to make a selection!");
                    break;
            }
        }
    }
}