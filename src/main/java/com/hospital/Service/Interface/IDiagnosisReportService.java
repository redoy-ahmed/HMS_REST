package com.hospital.Service.Interface;

import com.hospital.Entity.DiagnosisReport;
import com.hospital.Response.GlobalResponse;

@org.springframework.stereotype.Service
public interface IDiagnosisReportService {

    GlobalResponse save(DiagnosisReport diagnosisReport);

    GlobalResponse getDiagnosisReport(Integer diagnosisReportId);

    GlobalResponse getDiagnosisReports();
}
