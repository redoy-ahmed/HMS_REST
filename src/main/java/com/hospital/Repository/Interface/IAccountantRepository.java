package com.hospital.Repository.Interface;

import com.hospital.Entity.Accountant;
import com.hospital.Entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAccountantRepository extends JpaRepository<Accountant, Integer> {
}
