package com.hospital.Service.Implementation.BedAllotment;

import com.hospital.Entity.BedAllotment;
import com.hospital.Repository.Interface.IBedAllotmentRepository;
import com.hospital.Response.ErrorMessages;
import com.hospital.Response.GlobalResponse;
import com.hospital.Response.ResponseData;
import com.hospital.Service.Interface.IBedAllotmentService;
import com.hospital.message.AppMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BedAllotmentService implements IBedAllotmentService {

    private IBedAllotmentRepository bedAllotmentRepository;

    @Autowired
    public BedAllotmentService(IBedAllotmentRepository bedAllotmentRepository) {
        this.bedAllotmentRepository = bedAllotmentRepository;
    }

    @Override
    public GlobalResponse save(BedAllotment bedAllotment) {
        bedAllotment = bedAllotmentRepository.save(bedAllotment);
        GlobalResponse globalResponse = new GlobalResponse();
        ResponseData responseData = new ResponseData();
        responseData.setBedAllotment(bedAllotment);
        globalResponse.setSuccess(true);
        globalResponse.setResponseData(responseData);
        return globalResponse;
    }

    @Override
    public GlobalResponse getBedAllotment(Integer bedId) {
        BedAllotment bedAllotment = bedAllotmentRepository.findById(bedId)
                .orElse(new BedAllotment());
        GlobalResponse globalResponse = new GlobalResponse();
        ResponseData responseData = new ResponseData();
        ErrorMessages errorMessages = new ErrorMessages();
        if (bedAllotment.getBedAllotmentId() != null) {
            responseData.setBedAllotment(bedAllotment);
            globalResponse.setSuccess(true);
            globalResponse.setResponseData(responseData);
        } else {
            globalResponse.setSuccess(false);
            errorMessages.setMessages(AppMessage.NO_BED_ALLOTMENT_FOUND);
            globalResponse.setErrorMessages(errorMessages);
        }
        return globalResponse;
    }

    @Override
    public GlobalResponse getBedAllotments() {
        List<BedAllotment> bedAllotmentList = bedAllotmentRepository.findAll();
        GlobalResponse globalResponse = new GlobalResponse();
        ResponseData responseData = new ResponseData();
        ErrorMessages errorMessages = new ErrorMessages();

        if (bedAllotmentList.size() > 0) {
            responseData.setBedAllotmentList(bedAllotmentList);
            globalResponse.setSuccess(true);
            globalResponse.setResponseData(responseData);
        } else {
            globalResponse.setSuccess(false);
            errorMessages.setMessages(AppMessage.NO_BED_ALLOTMENT_FOUND);
            globalResponse.setErrorMessages(errorMessages);
        }
        return globalResponse;
    }
}
