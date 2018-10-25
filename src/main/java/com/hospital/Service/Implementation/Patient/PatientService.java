package com.hospital.Service.Implementation.Patient;

import com.hospital.Entity.Patient;
import com.hospital.Repository.Interface.IPatientRepository;
import com.hospital.Response.ErrorMessages;
import com.hospital.Response.GlobalResponse;
import com.hospital.Response.ResponseData;
import com.hospital.Service.Base.BaseService;
import com.hospital.Service.Interface.IPatientService;
import com.hospital.message.AppMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PatientService extends BaseService implements IPatientService {

    private IPatientRepository patientRepository;

    @Autowired
    public PatientService(IPatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public GlobalResponse save(Patient patient) {
        patient = patientRepository.save(patient);
        ResponseData responseData = new ResponseData();
        responseData.setPatient(patient);
        globalResponse.setSuccess(true);
        globalResponse.setResponseData(responseData);
        return globalResponse;
    }

    @Override
    public GlobalResponse getPatient(Integer doctorId) {
        Patient patient = patientRepository.getOne(doctorId);
        ResponseData responseData = new ResponseData();
        ErrorMessages errorMessages = new ErrorMessages();

        if (!patient.getName().isEmpty()) {
            responseData.setPatient(patient);
            globalResponse.setSuccess(true);
            globalResponse.setResponseData(responseData);
        } else {
            globalResponse.setSuccess(false);
            errorMessages.setMessages(AppMessage.NO_PATIENT_FOUND);
            globalResponse.setErrorMessages(errorMessages);
        }
        return globalResponse;
    }

    @Override
    public GlobalResponse getPatients() {
        List<Patient> patientList = patientRepository.findAll();
        ResponseData responseData = new ResponseData();
        ErrorMessages errorMessages = new ErrorMessages();

        if (patientList.size() > 0) {
            responseData.setPatientList(patientList);
            globalResponse.setSuccess(true);
            globalResponse.setResponseData(responseData);
        } else {
            globalResponse.setSuccess(false);
            errorMessages.setMessages(AppMessage.NO_PATIENT_FOUND);
            globalResponse.setErrorMessages(errorMessages);
        }
        return globalResponse;
    }
}
