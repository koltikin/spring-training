package com.cydeo.Repository;

import com.cydeo.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserAccount, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    /** Write a derived query to read a user with an email? */
    UserAccount findByEmail(String emil);


    /** Write a derived query to read a user with a username? */
    UserAccount findByUsername(String userName);


    /** Write a derived query to list all users that contain a specific name? */
    List<UserAccount> findAllByUsernameContains(String pattern);


    /** Write a derived query to list all users that contain a specific name in the ignore case mode? */
    List<UserAccount> findAllByUsernameIgnoreCase(String userName);


    /** Write a derived query to list all users with an age greater than a specified age? */
    List<UserAccount> findAllByAccountDetails_AgeGreaterThan(int age);

    // ------------------- JPQL QUERIES ------------------- //

    /** Write a JPQL query that returns a user read by email? */
    @Query("SELECT ua FROM UserAccount ua WHERE ua.email = ?1")
    UserAccount fetchUserByEmail(String email);


    /** Write a JPQL query that returns a user read by username? */
    @Query("SELECT ua FROM UserAccount ua WHERE ua.username = :name")
    UserAccount fetchUserByUserName(String name);


    /** Write a JPQL query that returns all users? */
    @Query("select ua FROM UserAccount ua")
    List<UserAccount> getAllUser();


    // ------------------- Native QUERIES ------------------- //

    /** Write a native query that returns all users that contain a specific name? */
    @Query(nativeQuery = true, value = "SELECT * FROM user_account WHERE username ILIKE concat('%', ?1, '%')")
    List<UserAccount> getUserByNameContains(String name);


    /** Write a native query that returns all users? */

    @Query(nativeQuery = true, value = "SELECT * FROM user_account")
    List<UserAccount> readAllUser();

    /** Write a native query that returns all users in the range of ages? */
    @Query(nativeQuery = true, value = "SELECT ua.* FROM user_account ua JOIN account_details ad" +
            " ON ua.account_details_id = ad.account_details_id WHERE ad.age BETWEEN ?1 AND ?2")
    List<UserAccount> readAllUserAgeBetween(int low, int high);


    /** Write a native query to read a user by email? */
    @Query(nativeQuery = true, value = "SELECT * FROM user_account WHERE email = ?1")
    UserAccount getUserByEmail(String email);


}
