package com.cydeo.Repository;

import com.cydeo.entity.MovieCinema;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
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
    @Query("SELECT mc FROM MovieCinema mc WHERE mc.dateTime > :date ")
    List<MovieCinema> fetchAllBeforeDate(LocalDate date);

    /** Write a native query that returns all movie cinemas by location name */
    @Query("SELECT mc FROM MovieCinema mc WHERE mc.cinema.location.name = :name")
    List<MovieCinema> fetchAllByLocationName(String name);

    /**  ------------------- Native QUERIES ------------------- // */

    /** Write a native query to count all movie cinemas by cinema id */
    @Query(nativeQuery = true, value = "SELECT count(*) FROM movie_cinema WHERE cinema_id = ?1")
    List<MovieCinema> countAllByCinemaID(Long id);

    /** Write a native query that returns all movie cinemas by location name */
    @Query(nativeQuery = true, value = "SELECT * FROM movie_cinema mc Join cinema c ON mc.cinema_id = c.cinema_id" +
    " JOIN location l ON l.location_id = c.location_id WHERE l.name = :name")
    List<MovieCinema> retrieveAllByLocationName(String name);

}
