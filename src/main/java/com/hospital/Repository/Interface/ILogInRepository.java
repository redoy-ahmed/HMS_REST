package com.hospital.Repository.Interface;

import com.hospital.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ILogInRepository extends JpaRepository<User, Integer> {

    @Transactional(readOnly = true)
    @Query(value = "select * from user where email =:email and password =:passwrod", nativeQuery = true)
    User login(@Param("email") String email, @Param("passwrod") String passwrod);
}