package com.hospital.Repository.Interface;

import com.hospital.Entity.BloodBank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBloodBankRepository extends JpaRepository<BloodBank, Integer> {
}
