package com.hospital.Controller.DiagnosisReport;

import com.hospital.Entity.DiagnosisReport;
import com.hospital.Entity.Doctor;
import com.hospital.Response.GlobalResponse;
import com.hospital.Service.Interface.IDiagnosisReportService;
import com.hospital.Service.Interface.IDoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DiagnosisReportController {

    private IDiagnosisReportService diagnosisReportService;

    @Autowired
    public DiagnosisReportController(IDiagnosisReportService diagnosisReportService) {
        this.diagnosisReportService = diagnosisReportService;
    }

    @PostMapping("/api/diagnosisReport/post")
    @ResponseBody
    public GlobalResponse save(@RequestBody DiagnosisReport diagnosisReport) {
        return diagnosisReportService.save(diagnosisReport);
    }

    @GetMapping("/api/diagnosisReport/get/{diagnosis_report_id}")
    public GlobalResponse getDiagnosisReport(@PathVariable("diagnosis_report_id") Integer diagnosisReportId) {
        return diagnosisReportService.getDiagnosisReport(diagnosisReportId);
    }

    @GetMapping("/api/diagnosisReport/getAll")
    public GlobalResponse getAllDiagnosisReports() {
        return diagnosisReportService.getDiagnosisReports();
    }
}
