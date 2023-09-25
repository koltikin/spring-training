package com.cydeo.Repository;

import com.cydeo.entity.AccountDetails;
import com.cydeo.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AccountRepository extends JpaRepository<AccountDetails, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    /** Write a derived query to list all accounts with a specific country or state */
    List<AccountDetails> findAccountDetailsByCountryOrState(String country, String state);


    /** Write a derived query to list all accounts with age lower than or equal to a specific value */
    List<AccountDetails> findAccountDetailsByAgeIsLessThanEqual(int age);


    /** Write a derived query to list all accounts with a specific role */
    List<AccountDetails> findByRole(UserRole userRole);


    /** Write a derived query to list all accounts between a range of ages */
    List<AccountDetails> findByAgeIsBetween(int age1,int age2);

    /** Write a derived query to list all accounts where the beginning of the address contains the keyword */
    List<AccountDetails> findByAddressStartsWith(String keyword);

    /**Write a derived query to sort the list of accounts with age */
    List<AccountDetails> findByOrderByAge();

    // ------------------- JPQL QUERIES ------------------- //

    /** Write a JPQL query that returns all accounts */
    @Query("SELECT a FROM AccountDetails a")
    List<AccountDetails> retrieveAllAccounts();

    /** Write a JPQL query to list all admin accounts */
    @Query("SELECT a FROM AccountDetails a WHERE a.role = 'ADMIN' ")
    List<AccountDetails> retrieveAllAdmin();


    //Write a JPQL query to sort all accounts with age
    @Query("SELECT a FROM AccountDetails a ORDER BY a.age")
    List<AccountDetails> retrieveAllSortByAge();

    @Query("SELECT a FROM AccountDetails a ORDER BY a.age DESC ")
    List<AccountDetails> retrieveAllSortByAgeDesc();


    // ------------------- Native QUERIES ------------------- //

    //Write a native query to read all accounts with an age lower than a specific value


    //Write a native query to read all accounts that a specific value can be containable in the name, address, country, state, city


    //Write a native query to read all accounts with an age higher than a specific value


}
