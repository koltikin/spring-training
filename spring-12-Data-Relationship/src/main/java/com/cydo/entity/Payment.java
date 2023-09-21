package com.cydo.entity;

import com.cydo.enums.PaymentStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(columnDefinition = "DATE")
    private LocalDate createdDate;

//    @Column(precision = 5,scale = 2)
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

    @OneToOne(cascade={CascadeType.PERSIST,CascadeType.MERGE})
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "ziya") // rename the column name
    private PaymentDetail paymentDetail;

    @ManyToOne
    private Merchant merchant;

    @ManyToOne
    private Customer customer;

    @OneToOne
    private Cart cart;

    public Payment(LocalDate createdDate, BigDecimal amount, PaymentStatus paymentStatus) {
        this.createdDate = createdDate;
        this.amount = amount;
        this.paymentStatus = paymentStatus;
    }
}
