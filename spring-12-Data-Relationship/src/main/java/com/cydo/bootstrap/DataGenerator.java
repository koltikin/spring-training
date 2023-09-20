package com.cydo.bootstrap;

import com.cydo.entity.Customer;
import com.cydo.entity.Merchant;
import com.cydo.entity.Payment;
import com.cydo.entity.PaymentDetail;
import com.cydo.enums.PaymentStatus;
import com.cydo.repository.CustomerRepository;
import com.cydo.repository.MerchantRepository;
import com.cydo.repository.PaymentDetailRepository;
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
    private final MerchantRepository merchantRepository;
    private final PaymentDetailRepository paymentDetailRepository;
    private final CustomerRepository customerRepository;
    @Override
    public void run(String... args) throws Exception {

        Payment payment1 = new Payment(LocalDate.of(2022,4,19),new BigDecimal("150"), PaymentStatus.SUCCESS);
        PaymentDetail paymentDetail1 = new PaymentDetail(new BigDecimal("140000"),new BigDecimal("145.45782"),LocalDate.of(2022,4,24));

        payment1.setPaymentDetail(paymentDetail1);

        Payment payment2 = new Payment(LocalDate.of(2022,4,25),new BigDecimal("100000"), PaymentStatus.FAILURE);
        PaymentDetail paymentDetail2 = new PaymentDetail(new BigDecimal("90000"),new BigDecimal("5000"),LocalDate.of(2022,4,29));

        Merchant merchant1 = new Merchant("AmazonSubMerchant","M123",new BigDecimal("0.25"),new BigDecimal("3.25"),5);
        Customer customer1 = new Customer("msmith","Mike","Smith","msmith@cydeo.com","VA");

        payment1.setMerchant(merchant1);
        payment2.setMerchant(merchant1);

        payment2.setPaymentDetail(paymentDetail2);

        merchantRepository.save(merchant1);
        customerRepository.save(customer1);
        paymentRepository.saveAll(Arrays.asList(payment1,payment2));

//        paymentRepository.delete(payment1);
//        System.out.println("payment 2**************>: "+paymentRepository.findById(1L));
//        System.out.println("paymentDetail 2**************>: "+paymentRepository.findById(2L).get().getPaymentDetail());
//        System.out.println("paymentDetail 1**************>: "+paymentDetailRepository.findById(1L));



    }
}
