package com.springboot.springbootdemo.employee.service;

import com.springboot.springbootdemo.employee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

//No need to add @Repository
public interface EmployeeService {

    Employee saveEmployee(Employee employee);
}
