package com.springboot.springbootdemo.employee.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//@Data a shortcut for @ToString, @EqualsAndHashCode,
// @Getter on all fields, @Setter on all non-final fields, and @RequiredArgsConstructor
@Data
//@Entity specifies that the class is an entity
@Entity
//@Table annotation specifies the name of the database table to be used for mapping
@Table(name="employees")
public class Employee {

    //@Id specifies the primary key of the entity
    @Id
    private long id;
    private String firstName;
    private String lastName;
    private String email;


}
