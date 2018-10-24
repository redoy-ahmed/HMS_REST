package com.hospital.Repository.Interface;

import com.hospital.Entity.BloodDonor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBloodDonorRepository extends JpaRepository<BloodDonor, Integer> {
}
