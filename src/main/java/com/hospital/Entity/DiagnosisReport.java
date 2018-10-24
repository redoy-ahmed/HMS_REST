package com.hospital.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "diagnosis_report")
public class DiagnosisReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "diagnosis_report_id")
    private Integer diagnosisReportId;

    @Column(name = "report_type")
    private String reportType;

    @Column(name = "document_type")
    private String documentType;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "prescription_id")
    private Integer prescriptionId;

    @Column(name = "description")
    private String description;

    @Column(name = "timestamp")
    private String timestamp;

    @Column(name = "laboratorist_id")
    private Integer laboratoristId;

    public Integer getDiagnosisReportId() {
        return diagnosisReportId;
    }

    public void setDiagnosisReportId(Integer diagnosisReportId) {
        this.diagnosisReportId = diagnosisReportId;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Integer getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(Integer prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getLaboratoristId() {
        return laboratoristId;
    }

    public void setLaboratoristId(Integer laboratoristId) {
        this.laboratoristId = laboratoristId;
    }
}
