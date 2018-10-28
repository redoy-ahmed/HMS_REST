package com.hospital.Service.Implementation.BloodDonor;

import com.hospital.Entity.BloodDonor;
import com.hospital.Repository.Interface.IBloodDonorRepository;
import com.hospital.Response.ErrorMessages;
import com.hospital.Response.GlobalResponse;
import com.hospital.Response.ResponseData;
import com.hospital.Service.Interface.IBloodDonorService;
import com.hospital.message.AppMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BloodDonorService implements IBloodDonorService {

    private IBloodDonorRepository bloodDonorRepository;

    @Autowired
    public BloodDonorService(IBloodDonorRepository bloodDonorRepository) {
        this.bloodDonorRepository = bloodDonorRepository;
    }

    @Override
    public GlobalResponse save(BloodDonor bloodDonor) {
        bloodDonor = bloodDonorRepository.save(bloodDonor);
        GlobalResponse globalResponse = new GlobalResponse();
        ResponseData responseData = new ResponseData();
        responseData.setBloodDonor(bloodDonor);
        globalResponse.setSuccess(true);
        globalResponse.setResponseData(responseData);
        return globalResponse;
    }

    @Override
    public GlobalResponse getBloodDonor(Integer bloodDonorId) {
        BloodDonor bloodDonor = bloodDonorRepository.findById(bloodDonorId)
                .orElse(new BloodDonor());
        GlobalResponse globalResponse = new GlobalResponse();
        ResponseData responseData = new ResponseData();
        ErrorMessages errorMessages = new ErrorMessages();
        if (bloodDonor.getBloodDonorId() != null) {
            responseData.setBloodDonor(bloodDonor);
            globalResponse.setSuccess(true);
            globalResponse.setResponseData(responseData);
        } else {
            globalResponse.setSuccess(false);
            errorMessages.setMessages(AppMessage.NO_BLOOD_DONOR_FOUND);
            globalResponse.setErrorMessages(errorMessages);
        }
        return globalResponse;
    }

    @Override
    public GlobalResponse getBloodDonors() {
        List<BloodDonor> bloodDonorList = bloodDonorRepository.findAll();
        GlobalResponse globalResponse = new GlobalResponse();
        ResponseData responseData = new ResponseData();
        ErrorMessages errorMessages = new ErrorMessages();
        if (bloodDonorList.size() > 0) {
            responseData.setBloodDonorList(bloodDonorList);
            globalResponse.setSuccess(true);
            globalResponse.setResponseData(responseData);
        } else {
            globalResponse.setSuccess(false);
            errorMessages.setMessages(AppMessage.NO_BLOOD_DONOR_FOUND);
            globalResponse.setErrorMessages(errorMessages);
        }
        return globalResponse;
    }
}
