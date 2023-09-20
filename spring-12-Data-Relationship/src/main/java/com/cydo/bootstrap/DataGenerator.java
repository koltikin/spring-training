package com.cydo.bootstrap;

import com.cydo.entity.Payment;
import com.cydo.entity.PaymentDetail;
import com.cydo.enums.PaymentStatus;
import com.cydo.repository.PaymentRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;

@Component
@AllArgsConstructor
public class DataGenerator implements CommandLineRunner {

    private final PaymentRepository paymentRepository;
    @Override
    public void run(String... args) throws Exception {

        Payment payment1 = new Payment(LocalDate.of(2022,4,19),new BigDecimal("150000"), PaymentStatus.SUCCESS);
        PaymentDetail paymentDetail1 = new PaymentDetail(new BigDecimal("140000"),new BigDecimal("10000"),LocalDate.of(2022,4,24));

        payment1.setPaymentDetail(paymentDetail1);

        Payment payment2 = new Payment(LocalDate.of(2022,4,25),new BigDecimal("100000"), PaymentStatus.FAILURE);
        PaymentDetail paymentDetail2 = new PaymentDetail(new BigDecimal("90000"),new BigDecimal("5000"),LocalDate.of(2022,4,29));

        payment2.setPaymentDetail(paymentDetail2);

        paymentRepository.saveAll(Arrays.asList(payment1,payment2));
        paymentRepository.delete(payment1);

    }
}
