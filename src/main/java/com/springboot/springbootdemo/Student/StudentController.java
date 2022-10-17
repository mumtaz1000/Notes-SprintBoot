//Student is source name and Controller is suffix
package com.springboot.springbootdemo.Student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @GetMapping("/student")
    public Student getStudent() {
        return new Student("Ramesh","Fadatare");
    }
}
