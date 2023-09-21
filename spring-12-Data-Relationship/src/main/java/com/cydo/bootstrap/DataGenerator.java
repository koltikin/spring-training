package com.cydo.bootstrap;

import com.cydo.entity.*;
import com.cydo.enums.PaymentStatus;
import com.cydo.repository.*;
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
    private final CartRepository cartRepository;
    private final ItemRepository itemRepository;
    @Override
    public void run(String... args) throws Exception {

        Payment payment1 = new Payment(LocalDate.of(2022,4,19),new BigDecimal("150"), PaymentStatus.SUCCESS);
        PaymentDetail paymentDetail1 = new PaymentDetail(new BigDecimal("140000"),new BigDecimal("145.45782"),LocalDate.of(2022,4,24));

        Payment payment2 = new Payment(LocalDate.of(2022,4,25),new BigDecimal("100000"), PaymentStatus.FAILURE);
        PaymentDetail paymentDetail2 = new PaymentDetail(new BigDecimal("90000"),new BigDecimal("5000"),LocalDate.of(2022,4,29));

        Merchant merchant1 = new Merchant("AmazonSubMerchant","M123",new BigDecimal("0.25"),new BigDecimal("3.25"),5);
        Customer customer1 = new Customer("msmith","Mike","Smith","msmith@cydeo.com","VA");

        Item item1 = new Item("Milk","M01");
        Item item2 = new Item("Sugar","S01");
        Item item3 = new Item("Bread","B01");

        Cart cart1 = new Cart();
        Cart cart2 = new Cart();


        payment1.setCustomer(customer1);
        payment2.setCustomer(customer1);

        payment1.setCart(cart1);
        payment2.setCart(cart2);

        payment1.setPaymentDetail(paymentDetail1);
        payment2.setPaymentDetail(paymentDetail2);

        payment1.setMerchant(merchant1);
        payment2.setMerchant(merchant1);

        cart1.setItems(Arrays.asList(item1,item2,item3));
        cart2.setItems(Arrays.asList(item1,item3));

        merchantRepository.save(merchant1);
        customerRepository.save(customer1);
        itemRepository.saveAll(Arrays.asList(item1,item2,item3));
        cartRepository.saveAll(Arrays.asList(cart1,cart2));
        paymentRepository.saveAll(Arrays.asList(payment1,payment2));





//        paymentRepository.delete(payment1);
//        System.out.println("payment 2**************>: "+paymentRepository.findById(1L));
//        System.out.println("paymentDetail 2**************>: "+paymentRepository.findById(2L).get().getPaymentDetail());
//        System.out.println("paymentDetail 1**************>: "+paymentDetailRepository.findById(1L));

//        System.out.println("items*****************>: "+ cartRepository.findById(1L));



    }
}
