package com.cydeo.repository;

import com.cydeo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.time.LocalDate;
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

    /** display all employees that has been hired between "" and "" */
    List<Employee> findByHireDateAfterAndHireDateAfter(LocalDate startDate, LocalDate endDate);
    List<Employee> findByHireDateBetween(LocalDate startDate, LocalDate endDate);

    /** display all employees salary grater than equal to "" in order */
    List<Employee> findBySalaryGreaterThanEqualOrderBySalary(BigDecimal salary);
    List<Employee> findBySalaryGreaterThanEqualOrderBySalaryDesc(BigDecimal salary);


    /** display top 3 unique employees tha is making less than '' salary */
    List<Employee> findDistinctFirst3BySalaryLessThan(BigDecimal salary);


    /** display all employees that not have email address */
    List<Employee> findByEmailIsNull();


                      /** JPQL */


   @Query("select e from Employee e where e.email='bdaily6k@ucla.edu'")
   Employee retrieveEmployeeDetail();

   @Query("select e.salary from Employee e where e.email = 'bdaily6k@ucla.edu'")
    BigDecimal retrieveEmployeeSalary();





}
