//Simple Hello World Rest API project
package com.springboot.springbootdemo.HelloWorldController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


//@Controller annotation indicates that the annotated class is a controller.
//@ResponseBody for get, post, put and delete response
//@RestController is a combination of @Controller and @ResponseBody
@RestController
public class HelloWorldController {

    //@GetMapping methods in the @Controller classes handle the HTTP GET requests
    //if we do not write ("/hello-world") then the response will be on localhost:8080

    @GetMapping("/hello-world")
    public String helloWorld(){
        return "Hello World!";
    }
}
