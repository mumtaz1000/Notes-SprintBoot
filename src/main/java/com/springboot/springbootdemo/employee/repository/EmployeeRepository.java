package com.springboot.springbootdemo.employee.repository;

import com.springboot.springbootdemo.employee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/*Spring data Jpa internally provides @Repository
 so no need to add @Repository to interface*/

/*Spring data Jpa by default made JpaRepository methods
 transactional so no need to add @Transactional in Service class*/
public interface EmployeeRepository extends JpaRepository <Employee, Long>{

}
