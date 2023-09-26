package com.cydeo.Repository;

import com.cydeo.entity.Ticket;
import com.cydeo.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.w3c.dom.stylesheets.LinkStyle;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    /** Write a derived query to count how many tickets a user bought */
    int countAllByUserAccountId(Long id);


    /** Write a derived query to list all tickets by specific email */
    List<Ticket> findAllByUserAccount_Email(String email);


    /** Write a derived query to count how many tickets are sold for a specific movie */
    int countAllByMovieCinema_Movie_Name(String name);


    /** Write a derived query to list all tickets between a range of dates */
    List<Ticket> findAllByDateTimeBetween(LocalDateTime startDate, LocalDateTime endDate);


    // ------------------- JPQL QUERIES ------------------- //

    /** Write a JPQL query that returns all tickets are bought from a specific user */
    @Query("SELECT t FROM Ticket t WHERE t.userAccount.id = ?1")
    List<Ticket> fetchAllTicketsUserHave(Long userId);


    /** Write a JPQL query that returns all tickets between a range of dates */
    @Query("SELECT t FROM Ticket t WHERE t.dateTime BETWEEN ?1 And ?2")
    List<Ticket> fetchAllTicketsBetweenDate(LocalDateTime startDate,LocalDateTime endDate);

    // ------------------- Native QUERIES ------------------- //

    /** Write a native query to count the number of tickets a user bought */
    @Query(nativeQuery = true, value = "SELECT count(*) FROM ticket WHERE user_account_id = ?1")
    List<Ticket> retrieveAllTicketByUser(long id);

    /** Write a native query to count the number of tickets a user bought in a specific range of dates */
    @Query(nativeQuery = true, value = "SELECT count(*) FROM ticket WHERE user_account_id = ?1" +
            " AND date_time BETWEEN ?2 AND ?2")
    List<Ticket> retrieveAllTicketsBetweenDate(LocalDateTime startDate,LocalDateTime endDate);


    /** Write a native query to distinct all tickets by movie name */
    @Query(nativeQuery = true, value = "SELECT distinct(t.*) FROM ticket t JOIN movie_cinema mc" +
            " ON t.movie_cinema_id = mc.movie_cinema_id JOIN movie m" +
            " ON mc.movie_id = m.movie_id WHERE m.name = ?1")
    List<Ticket> distinctAllTicketsByMovieName(String name);


    /** Write a native query to find all tickets by user email */
    @Query(nativeQuery = true, value = "SELECT t.* FROM ticket t JOIN user_account ua" +
            " ON t.user_account_id = ua.user_account_id WHERE ua.email = ?1")
    List<Ticket> findAllTicketsByUserEmail(String email);



    /** Write a native query that returns all tickets */
    @Query(nativeQuery = true, value = "SELECT * FROM ticket")
    List<Ticket> retrieveAllTickets();


    /** Write a native query to list all tickets where a specific value should be containable in the username or account name or movie name */
    @Query(nativeQuery = true, value = "SELECT t.* FROM ticket t JOIN user_account ua" +
            " ON t.user_account_id = ua.user_account_id JOIN account_details ad" +
            " ON ua.account_details_id = ad.account_details_id JOIN movie_cinema mc" +
            " ON t.movie_cinema_id = mc.movie_cinema_id JOIN movie mo" +
            " ON mc.movie_id = mo.movie_id WHERE ua.name = :userName OR ad.name = :accountDetailName OR mo.name = :movieName")

    List<Ticket> retrieveAllBySearchCriteria(String userName, String accountDetailName, String movieName);
}
