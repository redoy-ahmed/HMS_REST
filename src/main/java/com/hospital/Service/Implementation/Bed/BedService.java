package com.hospital.Service.Implementation.Bed;

import com.hospital.Entity.Bed;
import com.hospital.Repository.Interface.IBedRepository;
import com.hospital.Response.ErrorMessages;
import com.hospital.Response.GlobalResponse;
import com.hospital.Response.ResponseData;
import com.hospital.Service.Interface.IBedService;
import com.hospital.message.AppMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BedService implements IBedService {

    private IBedRepository bedRepository;

    @Autowired
    public BedService(IBedRepository bedRepository) {
        this.bedRepository = bedRepository;
    }

    @Override
    public GlobalResponse save(Bed bed) {
        bed = bedRepository.save(bed);
        GlobalResponse globalResponse = new GlobalResponse();
        ResponseData responseData = new ResponseData();
        responseData.setBed(bed);
        globalResponse.setSuccess(true);
        globalResponse.setResponseData(responseData);
        return globalResponse;
    }

    @Override
    public GlobalResponse getBed(Integer bedId) {
        Bed bed = bedRepository.findById(bedId)
                .orElse(new Bed());
        GlobalResponse globalResponse = new GlobalResponse();
        ResponseData responseData = new ResponseData();
        ErrorMessages errorMessages = new ErrorMessages();
        if (bed.getBedId() != null) {
            responseData.setBed(bed);
            globalResponse.setSuccess(true);
            globalResponse.setResponseData(responseData);
        } else {
            globalResponse.setSuccess(false);
            errorMessages.setMessages(AppMessage.NO_BED_FOUND);
            globalResponse.setErrorMessages(errorMessages);
        }
        return globalResponse;
    }

    @Override
    public GlobalResponse getBeds() {
        List<Bed> bedList = bedRepository.findAll();
        GlobalResponse globalResponse = new GlobalResponse();
        ResponseData responseData = new ResponseData();
        ErrorMessages errorMessages = new ErrorMessages();
        if (bedList.size() > 0) {
            responseData.setBedList(bedList);
            globalResponse.setSuccess(true);
            globalResponse.setResponseData(responseData);
        } else {
            globalResponse.setSuccess(false);
            errorMessages.setMessages(AppMessage.NO_BED_FOUND);
            globalResponse.setErrorMessages(errorMessages);
        }
        return globalResponse;
    }
}
