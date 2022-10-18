package com.springboot.springbootdemo.employee.model;

import lombok.Data;

import javax.persistence.*;

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
    //@GeneratedValue specifies strategies for the values of primary keys
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //@Column is used to specify the mapped column for a persistent property or field
    @Column(name = "first_name",
    nullable = false)
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;


}
