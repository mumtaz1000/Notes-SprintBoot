package com.springboot.springbootdemo.employee.service;

import com.springboot.springbootdemo.employee.model.Employee;
import com.springboot.springbootdemo.employee.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    //We are using constructor based dependency

    //No need of @Autowired when we have one constructor in Spring bean
    //Spring Boot will use constructor and will inject all dependencies
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

}
