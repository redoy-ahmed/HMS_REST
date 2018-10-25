package com.hospital.Service.Implementation.BloodBank;

import com.hospital.Entity.BloodBank;
import com.hospital.Repository.Interface.IBloodBankRepository;
import com.hospital.Response.ErrorMessages;
import com.hospital.Response.GlobalResponse;
import com.hospital.Response.ResponseData;
import com.hospital.Service.Base.BaseService;
import com.hospital.Service.Interface.IBloodBankService;
import com.hospital.message.AppMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BloodBankService extends BaseService implements IBloodBankService {

    private IBloodBankRepository bloodBankRepository;

    @Autowired
    public BloodBankService(IBloodBankRepository bloodBankRepository) {
        this.bloodBankRepository = bloodBankRepository;
    }

    @Override
    public GlobalResponse save(BloodBank bloodBank) {
        bloodBank = bloodBankRepository.save(bloodBank);
        ResponseData responseData = new ResponseData();

        responseData.setBloodBank(bloodBank);
        globalResponse.setSuccess(true);
        globalResponse.setResponseData(responseData);
        return globalResponse;
    }

    @Override
    public GlobalResponse getBloodGroup(Integer bloodGroupId) {
        BloodBank bloodBank = bloodBankRepository.getOne(bloodGroupId);
        ResponseData responseData = new ResponseData();
        ErrorMessages errorMessages = new ErrorMessages();

        if (bloodBank.getBloodGroupId() != null) {
            responseData.setBloodBank(bloodBank);
            globalResponse.setSuccess(true);
            globalResponse.setResponseData(responseData);
        } else {
            globalResponse.setSuccess(false);
            errorMessages.setMessages(AppMessage.NO_BLOOD_FOUND);
            globalResponse.setErrorMessages(errorMessages);
        }
        return globalResponse;
    }

    @Override
    public GlobalResponse getBloodGroups() {
        List<BloodBank> bloodBankList = bloodBankRepository.findAll();
        ResponseData responseData = new ResponseData();
        ErrorMessages errorMessages = new ErrorMessages();

        if (bloodBankList.size() > 0) {
            responseData.setBloodBankList(bloodBankList);
            globalResponse.setSuccess(true);
            globalResponse.setResponseData(responseData);
        } else {
            globalResponse.setSuccess(false);
            errorMessages.setMessages(AppMessage.NO_BLOOD_FOUND);
            globalResponse.setErrorMessages(errorMessages);
        }
        return globalResponse;
    }
}
