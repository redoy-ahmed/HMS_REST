package com.hospital.Repository.Interface;

import com.hospital.Entity.DiagnosisReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDiagnosisReportRepository extends JpaRepository<DiagnosisReport, Integer>{
}