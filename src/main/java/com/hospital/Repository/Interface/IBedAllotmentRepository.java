package com.hospital.Repository.Interface;

import com.hospital.Entity.BedAllotment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBedAllotmentRepository extends JpaRepository<BedAllotment, Integer> {
}
