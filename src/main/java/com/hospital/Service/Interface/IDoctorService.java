package com.hospital.Service.Interface;

import com.hospital.Entity.Doctor;
import com.hospital.Response.GlobalResponse;

@org.springframework.stereotype.Service
public interface IDoctorService {

    GlobalResponse save(Doctor doctor);

    GlobalResponse getDoctor(Integer doctorId);

    GlobalResponse getDoctors();
}
