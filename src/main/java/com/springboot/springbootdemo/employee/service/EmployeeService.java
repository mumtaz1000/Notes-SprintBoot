package com.springboot.springbootdemo.employee.service;

import com.springboot.springbootdemo.employee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//No need to add @Repository
public interface EmployeeService {

    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(long id);
    Employee updateEmployee(Employee employee, long id);
    void deleteEmployee(long id);
}
