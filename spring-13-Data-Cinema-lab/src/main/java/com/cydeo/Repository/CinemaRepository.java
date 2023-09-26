package com.cydeo.Repository;

import com.cydeo.entity.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.Optional;


@Repository
public interface CinemaRepository extends JpaRepository<Cinema, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    /** Write a derived query to get cinema with a specific name */
//    Cinema findByName(String name);
    Optional<Cinema> findByName(String name);


    /** Write a derived query to read sorted the top 3 cinemas that contains a specific sponsored name */
    List<Cinema> findTop3BySponsoredNameContainingOrderBySponsoredName(String name);

    /** Write a derived query to list all cinemas in a specific country */
    List<Cinema> findAllByLocation_Country(String country);


    /** Write a derived query to list all cinemas with a specific name or sponsored name */
    List<Cinema> findAllByNameOrSponsoredName(String name,String sponsoredName);

    // ------------------- JPQL QUERIES ------------------- //

    /** Write a JPQL query to read the cinema name with a specific id */
    @Query("SELECT c FROM Cinema c WHERE c.id = ?1")
    Cinema fetchCinemaNameById(Integer id);

    /** Write a native query to read all cinemas by location country */
    @Query("SELECT c FROM Cinema c WHERE c.location.name = :name")
    List<Cinema> fetchAllCinemaByLocationName(String name);

    /** Write a native query to distinct all cinemas by sponsored name */
    @Query("SELECT c FROM Cinema c WHERE" +
            " c.sponsoredName IN (SELECT DISTINCT(c.sponsoredName) FROM Cinema)")
    List<Cinema> fetchDistinctBySponsoredName();


    // ------------------- Native QUERIES ------------------- //

    /** Write a native query to read all cinemas by location country */
    @Query(nativeQuery = true, value = "SELECT * FROM Cinema c JOIN location l" +
    " ON l.location_id = c.location_id WHERE country = :country")
    List<Cinema> retrieveAllCinemaByCountry(String country);

    @Query(nativeQuery = true, value = "SELECT * FROM Cinema c JOIN location l" +
            " ON l.location_id = c.location_id WHERE l.name = ?1")
    List<Cinema> retrieveAllCinemaByLocationName(String name);

    /** Write a native query to read all cinemas by name or sponsored name contains a specific pattern */
    @Query(nativeQuery = true,value = "SELECT * FROM cinema WHERE name ILIKE concat('%', :value, '%')" +
            " OR sponsored_name ILIKE concat('%' :value '%') ")
    List<Cinema> retrieveAllCinemaByNameOrSponsoredName(String value);

    /** Write a native query to sort all cinemas by name */
    @Query(nativeQuery = true, value = "SELECT * FROM cinema ORDER BY name")
    List<Cinema> retrieveAllCinemaSortByName();



    /** Write a native query to distinct all cinemas by sponsored name */
    @Query(nativeQuery = true, value = "SELECT * FROM cinema WHERE" +
            " sponsored_name IN (SELECT DISTINCT(sponsored_name) FROM cinema)")
    List<Cinema> distinctBySponsoredName();


}
