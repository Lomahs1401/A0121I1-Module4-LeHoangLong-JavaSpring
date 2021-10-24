package com.example.shopping_cart.repository;

import com.example.shopping_cart.model.Account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {

    @Modifying
    @Transactional
    @Query(value = "UPDATE Account SET password = :password, fullName = :fullName, email = :email, photo = :photo" +
            ", activated = :activated, admin = :admin WHERE username = :username", nativeQuery = true)
    public void update(@Param("username") String username, @Param("password") String password, @Param("fullName") String fullName, 
        @Param("email") String email, @Param("photo") String photo, @Param("activated") Boolean activated, @Param("admin") Boolean admin);
}
