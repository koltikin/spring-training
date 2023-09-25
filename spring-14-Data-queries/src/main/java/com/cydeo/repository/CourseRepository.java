package com.cydeo.repository;

import com.cydeo.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.stream.Stream;

public interface CourseRepository extends JpaRepository<Course,Long> {

    /** find all courses by category */
    List<Course> findAllByCategory(String category_name);

    /**  Checks if a courses with the supplied name exists. return true if exists, false otherwise */
    boolean existsByName(String name);

    /** return the count of the course for the given category */
    int countByCategory(String category);


    /** find all the courses that start with the given course name string */
    List<Course> findByNameStartsWith(String name);

    /** find all the courses by category and returns a stream */

    Stream<Course> streamAllByCategory(String category);












}
