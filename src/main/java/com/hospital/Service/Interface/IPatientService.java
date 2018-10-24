package com.hospital.Service.Interface;

import com.hospital.Entity.Patient;
import com.hospital.Response.GlobalResponse;


@org.springframework.stereotype.Service
public interface IPatientService {

    GlobalResponse save(Patient patient);

    GlobalResponse getPatient(Integer patientId);

    GlobalResponse getPatients();
}