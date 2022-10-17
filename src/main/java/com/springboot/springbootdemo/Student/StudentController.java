//Student is source name and Controller is suffix
package com.springboot.springbootdemo.Student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    @GetMapping("/student")
    public Student getStudent() {
        return new Student("Ramesh","Fadatare");
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student("Sara","Malik"));
        students.add(new Student("Muhammad","Ali"));
        students.add(new Student("Puja","Sharma"));
        return students;
    }

    //Creating Rest API with path variable
    // for example http://localhost:8080/student/id
    //@PathVariable to bind the request URL template path variable
    //to the method variable

    @GetMapping("{firstName}/{lastName}")
    public Student studentPathVariable(
            @PathVariable("firstName")
            String firstName,
            @PathVariable("lastName")
            String lastName) {
        return new Student(firstName, lastName);
    }

}
