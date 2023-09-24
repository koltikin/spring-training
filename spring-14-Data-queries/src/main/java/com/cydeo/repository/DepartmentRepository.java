package com.cydeo.repository;

import com.cydeo.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department,String> {


    /** display all departments in the furniture department */

    List<Department> findByDepartment(String name);

    /** display all departments in the health division */

    List<Department> findAllByDivision(String division); // the same as findByDivision
    List<Department> findByDivision(String division); // the same as findAllByDivision
    List<Department> findByDivisionIs(String division); // the same as findByDivision
    List<Department> findByDivisionEquals(String division); // the same as findByDivision

    /** display all departments with division name ends with 'ics' */

    List<Department> findByDivisionEndsWithIgnoreCase(String str);

    /** display top 3 departments with division name includes 'Hea' without duplicates */

    List<Department> findDistinctTop3ByDivisionContaining(String str);




}
