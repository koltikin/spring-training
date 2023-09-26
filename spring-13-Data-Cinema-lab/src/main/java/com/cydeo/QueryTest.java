package com.cydeo;

import com.cydeo.Repository.*;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Component
@AllArgsConstructor
public class QueryTest implements CommandLineRunner {
    private final AccountRepository accountRepository;
    private final CinemaRepository cinemaRepository;
    private final GenreRepository genreRepository;
    private final MovieRepository movieRepository;
    private final MovieCinemaRepository movieCinemaRepository;
    private final TicketRepository ticketRepository;
    private final UserRepository userRepository;
    @Override
    public void run(String... args) throws Exception {
        System.out.println("*********** accountRepository derived Query *************************");
        System.out.println("findByAgeIsBetween: " + accountRepository.findByAgeIsBetween(28, 47)); // include both 28 and 47
        System.out.println("findByAddressStartsWith: " + accountRepository.findByAddressStartsWith("2"));
        System.out.println("findByOrderByAge: " + accountRepository.findByOrderByAge());

        System.out.println("*********** accountRepository JPQL Query *************************");
        System.out.println("retrieveAllAccounts: " + accountRepository.retrieveAllAccounts());
        System.out.println("*********** accountRepository native Query *************************");
        System.out.println("fetchAllContainsNameAddressCountryState: " + accountRepository.fetchAllContainsNameAddressCountryState1("tuc"));
        System.out.println("fetchAllAgeHigher: " + accountRepository.fetchAllAgeHigher(35));
        System.out.println("fetchAllAgeBetween: " + accountRepository.fetchAllAgeBetween(25,35));
        System.out.println("*********** cinemaRepository Native QUERIES *************************");
        System.out.println("retrieveAllCinemaByCountry: " + cinemaRepository.retrieveAllCinemaByCountry("United States"));
        System.out.println("fetchAllCinemaByLocationName: " + cinemaRepository.fetchAllCinemaByLocationName("AMC Village 7"));
        System.out.println("retrieveAllCinemaByLocationName: " + cinemaRepository.retrieveAllCinemaByLocationName("AMC Village 7"));

        System.out.println("*********** genreRepository derived Query *************************");
        System.out.println("findAll: " + genreRepository.findAll());
        System.out.println("fetchAllGenre: " + genreRepository.fetchAllGenre());
        System.out.println("retrieveAllNameContains: " + genreRepository.retrieveAllNameContains("c"));
        System.out.println("fetchAllNameContains: " + genreRepository.fetchAllNameContains("c"));

        System.out.println("*********** MovieCinema derived Query *************************");
        System.out.println("countAllByCinemaId: " + movieCinemaRepository.countAllByCinemaId(1));
        System.out.println("findByMovie_NameContains: " + movieCinemaRepository.findByMovie_NameContains("The"));
        System.out.println("fetchAllByLocationName: " + movieCinemaRepository.fetchAllByLocationName("AMC Empire 25"));

        System.out.println("*********** Movie Query *************************");

        System.out.println("findAllByPriceBetween: " + movieRepository.findAllByPriceBetween(BigDecimal.valueOf(15), BigDecimal.valueOf(20)));
        System.out.println("fetchAllPriceBetween: " + movieRepository.fetchAllPriceBetween(BigDecimal.valueOf(15), BigDecimal.valueOf(20)));
        System.out.println("findFirst5ByOrderByPriceDesc: " + movieRepository.findFirst5ByOrderByPriceDesc());
        System.out.println("retrieveTop5Expensive: " + movieRepository.retrieveTop5Expensive());

        System.out.println("*********** Ticket Query *************************");

        System.out.println("countAllByMovieCinema_Movie_Name: " + ticketRepository.countAllByMovieCinema_Movie_Name("Tenet"));
        System.out.println("fetchAllTicketsBetweenDate: " + ticketRepository.fetchAllTicketsBetweenDate(LocalDateTime.of(2020, 12, 5, 20, 00, 00, 0),
                LocalDateTime.of(2020, 12, 6, 20, 45, 00, 0)));
        System.out.println("distinctAllTicketsByMovieName: " + ticketRepository.distinctAllTicketsByMovieName("Tenet"));
        System.out.println("findAllTicketsByUserEmail: " + ticketRepository.findAllTicketsByUserEmail("faith.p@email.com"));

        System.out.println("*********** UserAccount Query *************************");

        System.out.println(userRepository.findAllByAccountDetails_AgeGreaterThan(46));

    }
}
