package com.hospital.Repository.Interface;

import com.hospital.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface ILogInRepository extends JpaRepository<User, Integer> {

    @Transactional(readOnly = true)
    @Query(value = "select * from user where username =:username and password =:password", nativeQuery = true)
    User login(@Param("username") String username, @Param("password") String password);

    @Transactional(readOnly = true)
    @Query(value = "select token from user where token =:token", nativeQuery = true)
    String getToken(@Param("token") String token);

    User findByUsername(String name);
}