package com.springboot.springbootdemo.employee.service;

import com.springboot.springbootdemo.employee.exception.ResourceNotFoundException;
import com.springboot.springbootdemo.employee.model.Employee;
import com.springboot.springbootdemo.employee.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        /*if (employee.isPresent()) {
            return employee.get();
        } else {
            throw new ResourceNotFoundException("Employee","Id",id);
        }*/

        return employeeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Employee", "Id", id));
    }

    @Override
    public Employee updateEmployee(Employee employee, long id) {
        //we need to check whether the employee with the given id exist in DB
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employee", "Id", id)
        );
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());

        //save employee to DB
        employeeRepository.save(existingEmployee);
        return existingEmployee;
    }

    @Override
    public void deleteEmployee(long id) {

        //we need to check whether the employee with the given id exist in DB
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employee", "Id", id)
        );

        employeeRepository.deleteById(id);
    }
}
