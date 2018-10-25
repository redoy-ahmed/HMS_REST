package com.hospital.Service.Implementation.Doctor;

import com.hospital.Entity.Doctor;
import com.hospital.Repository.Interface.IDoctorRepository;
import com.hospital.Response.ErrorMessages;
import com.hospital.Response.GlobalResponse;
import com.hospital.Response.ResponseData;
import com.hospital.Service.Base.BaseService;
import com.hospital.Service.Interface.IDoctorService;
import com.hospital.message.AppMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService extends BaseService implements IDoctorService {

    private IDoctorRepository doctorRepository;

    @Autowired
    public DoctorService(IDoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public GlobalResponse save(Doctor doctor) {
        doctor = doctorRepository.save(doctor);

        responseData.setDoctor(doctor);
        globalResponse.setSuccess(true);
        globalResponse.setResponseData(responseData);
        return globalResponse;
    }

    @Override
    public GlobalResponse getDoctor(Integer doctorId) {
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElse(new Doctor());

        if (!doctor.getName().isEmpty()) {
            responseData.setDoctor(doctor);
            globalResponse.setSuccess(true);
            globalResponse.setResponseData(responseData);
        } else {
            globalResponse.setSuccess(false);
            errorMessages.setMessages(AppMessage.NO_DOCTOR_FOUND);
            globalResponse.setErrorMessages(errorMessages);
        }
        return globalResponse;
    }

    @Override
    public GlobalResponse getDoctors() {
        List<Doctor> doctorList = doctorRepository.findAll();

        if (doctorList.size() > 0) {
            responseData.setDoctorList(doctorList);
            globalResponse.setSuccess(true);
            globalResponse.setResponseData(responseData);
        } else {
            globalResponse.setSuccess(false);
            errorMessages.setMessages(AppMessage.NO_DOCTOR_FOUND);
            globalResponse.setErrorMessages(errorMessages);
        }
        return globalResponse;
    }
}