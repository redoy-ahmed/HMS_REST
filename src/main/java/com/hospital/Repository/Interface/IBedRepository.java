package com.hospital.Repository.Interface;

import com.hospital.Entity.Bed;
import com.hospital.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBedRepository extends JpaRepository<Bed, Integer> {
}
