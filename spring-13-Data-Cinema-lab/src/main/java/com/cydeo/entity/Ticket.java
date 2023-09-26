package com.cydeo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AttributeOverride(name = "id",column = @Column(name = "ticket_id"))
public class Ticket extends BaseEntity {

    private Integer seatNumber;
    private Integer rowNumber;
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime dateTime;

    @ManyToOne
    @JoinColumn(name = "movie_cinema_id")
    private MovieCinema movieCinema;

    @ManyToOne
    @JoinColumn(name = "user_account_id")
    private UserAccount userAccount;
}
