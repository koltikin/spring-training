package com.cydeo.Repository;

import com.cydeo.entity.Movie;
import com.cydeo.enums.MovieState;
import com.cydeo.enums.MovieType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;


@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    /** Write a derived query to read a movie with a name */
    Movie findByName(String name);


    /** Write a derived query to list all movies between a range of prices */
    List<Movie> findAllByPriceBetween(BigDecimal low,BigDecimal high);


    /** Write a derived query to list all movies where duration exists in the specific list of duration */
    List<Movie> findAllByDurationIn(List<Integer> duration);

    /** Write a derived query to list all movies with higher than a specific release date */
    List<Movie> findAllByReleaseDateBefore(LocalDate releaseDate);


    /** Write a derived query to list all movies with a specific state and type */
    List<Movie> findAllByStateAndType(MovieState state, MovieType type);

    /** Write a native query to list the top 5 most expensive movies */
    List<Movie> findFirst5ByOrderByPriceDesc();


    // ------------------- JPQL QUERIES ------------------- //

    /** Write a JPQL query to list all movies between a range of prices */
//    @Query("SELECT m FROM Movie m WHERE m.price BETWEEN :low AND :high")
//    List<Movie> fetchAllPriceBetween(BigDecimal low, BigDecimal high);
    @Query("SELECT m FROM Movie m WHERE m.price BETWEEN ?1 AND ?2")
    List<Movie> fetchAllPriceBetween(BigDecimal low, BigDecimal high);

    /** Write a JPQL query that returns all movie names */
    @Query("SELECT m.name FROM Movie m")
    List<String> fetchAllMovieNames();

    // ------------------- Native QUERIES ------------------- //

    /** Write a native query that returns a movie by name */
    @Query(nativeQuery = true, value = "SELECT * FROM movie WHERE name = ?1")
    Movie retrieveMovieByName(String name);


    /** Write a native query that return the list of movies in a specific range of prices */
    @Query(nativeQuery = true,value = "SELECT * FROM movie WHERE price BETWEEN ?1 AND ?2")
    List<Movie> retrieveAllPriceBetween(BigDecimal low, BigDecimal high);


    /** Write a native query to return all movies where duration exists in the range of duration */
    @Query(nativeQuery = true, value = "SELECT * FROM movie WHERE duration IN ?1")
    List<Movie> retrieveAllDurationIn(List<Integer> duration);


    /** Write a native query to list the top 5 most expensive movies */
    @Query(nativeQuery = true, value = "SELECT * FROM movie ORDER BY price DESC LIMIT 5")
    List<Movie> retrieveTop5Expensive();


}
