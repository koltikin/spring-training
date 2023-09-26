package com.cydeo.Repository;

import com.cydeo.entity.MovieCinema;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Repository
public interface MovieCinemaRepository extends JpaRepository<MovieCinema, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    /** Write a derived query to read movie cinema with id */
    Optional<MovieCinema> findById(Long id);

    /** Write a derived query to count all movie cinemas with a specific cinema id */
    Integer countAllByCinemaId(long Id);

    /** Write a derived query to count all movie cinemas with a specific movie id */
    Integer countAllByMovieId(Long id);

    /** Write a derived query to list all movie cinemas with higher than a specific date */
    List<MovieCinema> findMovieCinemaByDateTimeBefore(LocalDateTime date);

    /** Write a derived query to find the top 3 expensive movies */
    List<MovieCinema> findTop3ByOrderByMoviePriceDesc();

    /** Write a derived query to list all movie cinemas that contain a specific movie name */
    List<MovieCinema> findByMovie_NameContains(String name);

    /** Write a derived query to list all movie cinemas in a specific location name */
    List<MovieCinema> findTopByCinema_Location_Name(String name);

    // ------------------- JPQL QUERIES ------------------- //

    /** Write a JPQL query to list all movie cinemas with higher than a specific date */


    // ------------------- Native QUERIES ------------------- //

    //Write a native query to count all movie cinemas by cinema id


    //Write a native query that returns all movie cinemas by location name


}
