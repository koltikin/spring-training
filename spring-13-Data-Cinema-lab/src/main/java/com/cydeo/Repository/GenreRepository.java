package com.cydeo.Repository;

import com.cydeo.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {
    // ------------------- DERIVED QUERIES ------------------- //
    /** Write a JPQL query that return all genres */
    List<Genre> findAll();

    // ------------------- JPQL QUERIES ------------------- //

    /** Write a JPQL query that return all genres */
    @Query("SELECT g FROM Genre g")
    List<Genre> fetchAllGenre();

    /** Write a native query that returns genres by containing name */
    @Query("SELECT g FROM Genre g WHERE lower(g.name) LIKE lower(concat('%', :value, '%'))") // Hibernate doesn't recognise ILKE
    List<Genre> fetchAllNameContains(String value);


    // ------------------- Native QUERIES ------------------- //

    /** Write a native query that returns genres by containing name */
    @Query(nativeQuery = true, value = "SELECT * FROM Genre WHERE name ILIKE concat('%', :value, '%')")
    List<Genre> retrieveAllNameContains(String value);


}
