package com.hospital.Response;

import com.hospital.Entity.*;

import java.util.List;

public class ResponseData {

    private User User;
    private Doctor Doctor;
    private List<Doctor> DoctorList;
    private Patient patient;
    private List<Patient> PatientList;
    private Accountant accountant;
    private Appointment appointment;
    private List<Appointment> AppointmentList;
    private Bed bed;
    private List<Bed> BedList;
    private BedAllotment bedAllotment;
    private List<BedAllotment> BedAllotmentList;
    private BloodBank bloodBank;
    private List<BloodBank> BloodBankList;
    private BloodDonor bloodDonor;
    private List<BloodDonor> BloodDonorList;
    private Department department;
    private List<Department> DepartmentList;
    private DiagnosisReport diagnosisReport;
    private List<DiagnosisReport> DiagnosisReportList;

    public User getUser() {
        return User;
    }

    public void setUser(User user) {
        User = user;
    }

    public Doctor getDoctor() {
        return Doctor;
    }

    public void setDoctor(Doctor doctor) {
        Doctor = doctor;
    }

    public List<Doctor> getDoctorList() {
        return DoctorList;
    }

    public void setDoctorList(List<Doctor> doctorList) {
        DoctorList = doctorList;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public List<Patient> getPatientList() {
        return PatientList;
    }

    public void setPatientList(List<Patient> patientList) {
        PatientList = patientList;
    }

    public Accountant getAccountant() {
        return accountant;
    }

    public void setAccountant(Accountant accountant) {
        this.accountant = accountant;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public List<Appointment> getAppointmentList() {
        return AppointmentList;
    }

    public void setAppointmentList(List<Appointment> appointmentList) {
        AppointmentList = appointmentList;
    }

    public Bed getBed() {
        return bed;
    }

    public void setBed(Bed bed) {
        this.bed = bed;
    }

    public List<Bed> getBedList() {
        return BedList;
    }

    public void setBedList(List<Bed> bedList) {
        BedList = bedList;
    }

    public BedAllotment getBedAllotment() {
        return bedAllotment;
    }

    public void setBedAllotment(BedAllotment bedAllotment) {
        this.bedAllotment = bedAllotment;
    }

    public List<BedAllotment> getBedAllotmentList() {
        return BedAllotmentList;
    }

    public void setBedAllotmentList(List<BedAllotment> bedAllotmentList) {
        BedAllotmentList = bedAllotmentList;
    }

    public BloodBank getBloodBank() {
        return bloodBank;
    }

    public void setBloodBank(BloodBank bloodBank) {
        this.bloodBank = bloodBank;
    }

    public List<BloodBank> getBloodBankList() {
        return BloodBankList;
    }

    public void setBloodBankList(List<BloodBank> bloodBankList) {
        BloodBankList = bloodBankList;
    }

    public BloodDonor getBloodDonor() {
        return bloodDonor;
    }

    public void setBloodDonor(BloodDonor bloodDonor) {
        this.bloodDonor = bloodDonor;
    }

    public List<BloodDonor> getBloodDonorList() {
        return BloodDonorList;
    }

    public void setBloodDonorList(List<BloodDonor> bloodDonorList) {
        BloodDonorList = bloodDonorList;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Department> getDepartmentList() {
        return DepartmentList;
    }

    public void setDepartmentList(List<Department> departmentList) {
        DepartmentList = departmentList;
    }

    public DiagnosisReport getDiagnosisReport() {
        return diagnosisReport;
    }

    public void setDiagnosisReport(DiagnosisReport diagnosisReport) {
        this.diagnosisReport = diagnosisReport;
    }

    public List<DiagnosisReport> getDiagnosisReportList() {
        return DiagnosisReportList;
    }

    public void setDiagnosisReportList(List<DiagnosisReport> diagnosisReportList) {
        DiagnosisReportList = diagnosisReportList;
    }
}
