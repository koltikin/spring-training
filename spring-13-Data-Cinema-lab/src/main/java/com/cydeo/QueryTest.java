package com.cydeo;

import com.cydeo.Repository.*;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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
        System.out.println("*********** accountRepository *************************");
        System.out.println("findByAgeIsBetween" + accountRepository.findByAgeIsBetween(28, 47)); // include both 28 and 47
        System.out.println("findByAddressStartsWith" + accountRepository.findByAddressStartsWith("2"));
        System.out.println("findByOrderByAge" + accountRepository.findByOrderByAge());
    }
}
