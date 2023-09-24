package com.cydeo.repository;

import com.cydeo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    /** display all employees with email address */
    List<Employee> findByEmail(String email);


    /** display all employees firstname ''  and  last name is ''
        also show all employees with email address '' */
    List<Employee> findByFirstNameAndLastNameOrEmail(String firstname, String lastname,String email);


    /** display all employees that first name is not '' */
    List<Employee> findByFirstNameNot(String firstname);
    List<Employee> findByFirstNameIsNot(String firstname);

    /** display all employees that last name is started with '' */
    List<Employee> findByLastNameStartsWith(String pattern);

    /** display all employees with salary higher than '' */
    List<Employee> findBySalaryGreaterThan(BigDecimal salary);

    /** display all employees with salary less than '' */
    List<Employee> findBySalaryLessThan(BigDecimal salary);

    /** display all employees with salary less than '' */







}
