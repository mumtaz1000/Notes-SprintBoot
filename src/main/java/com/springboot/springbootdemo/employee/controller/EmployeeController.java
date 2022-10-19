package com.springboot.springbootdemo.employee.controller;

import com.springboot.springbootdemo.employee.model.Employee;
import com.springboot.springbootdemo.employee.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Controller layer depends upon service layer so first update the service layer

//@Controller annotation indicates that the annotated class is a controller.
//@ResponseBody for get, post, put and delete response
//@RestController is a combination of @Controller and @ResponseBody
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //Build create employee REST API
    //@PostMapping will handle post http request
    @PostMapping()
    //@RequestBody allows us to retrieve the request's body
    // and automatically convert it to Java Object
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }

    //Build get all employee REST API
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    //Build get employee by id REST API
    // http://localhost:8080/api/employees/1
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long employeeId) {
        return new ResponseEntity<Employee>(employeeService.getEmployeeById(employeeId), HttpStatus.OK);
    }

    //Build update employee REST API
    // http://localhost:8080/api/employees/1
    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id,
                                                   @RequestBody Employee employee) {
        return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, id), HttpStatus.OK);
    }

    //Build delete employee REST API

    // http://localhost:8080/api/employees/1
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id) {

        //delete
        employeeService.deleteEmployee(id);
        return new ResponseEntity<String>("Employee deleted successfully", HttpStatus.OK);
    }
}
