package com.cydo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@NoArgsConstructor
@Data
@Entity
@Table(name = "paymentDetails")
public class PaymentDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private BigDecimal merchantPayoutAmount;
    private BigDecimal commissionAmount;
    @Column(columnDefinition = "DATE")
    private LocalDate payoutDate;

    @OneToOne(mappedBy = "paymentDetail")
    private Payment payment;

    public PaymentDetail(BigDecimal merchantPayoutAmount, BigDecimal commissionAmount, LocalDate payoutDate) {
        this.merchantPayoutAmount = merchantPayoutAmount;
        this.commissionAmount = commissionAmount;
        this.payoutDate = payoutDate;
    }

    @Override
    public String toString() {
        return "PaymentDetail{" +
                "id=" + id +
                ", merchantPayoutAmount=" + merchantPayoutAmount +
                ", commissionAmount=" + commissionAmount +
                ", payoutDate=" + payoutDate +
                '}';
    }
}
