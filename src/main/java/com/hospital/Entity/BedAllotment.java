package com.hospital.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "bed_allotment")
public class BedAllotment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bed_allotment_id")
    private Integer bedAllotmentId;

    @Column(name = "bed_id")
    private Integer bedId;

    @Column(name = "patient_id")
    private Integer patientId;

    @Column(name = "allotment_timestamp")
    private String allotmentTimestamp;

    @Column(name = "discharge_timestamp")
    private String dischargeTimestamp;

    public Integer getBedAllotmentId() {
        return bedAllotmentId;
    }

    public void setBedAllotmentId(Integer bedAllotmentId) {
        this.bedAllotmentId = bedAllotmentId;
    }

    public Integer getBedId() {
        return bedId;
    }

    public void setBedId(Integer bedId) {
        this.bedId = bedId;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public String getAllotmentTimestamp() {
        return allotmentTimestamp;
    }

    public void setAllotmentTimestamp(String allotmentTimestamp) {
        this.allotmentTimestamp = allotmentTimestamp;
    }

    public String getDischargeTimestamp() {
        return dischargeTimestamp;
    }

    public void setDischargeTimestamp(String dischargeTimestamp) {
        this.dischargeTimestamp = dischargeTimestamp;
    }
}
