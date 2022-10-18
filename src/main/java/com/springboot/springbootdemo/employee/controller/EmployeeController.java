package com.springboot.springbootdemo.employee.controller;

import com.springboot.springbootdemo.employee.model.Employee;
import com.springboot.springbootdemo.employee.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
        return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }


}
