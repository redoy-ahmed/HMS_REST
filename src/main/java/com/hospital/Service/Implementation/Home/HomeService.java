package com.hospital.Service.Implementation.Home;

import com.hospital.Dto.HomeDTO;
import com.hospital.Entity.Bed;
import com.hospital.Entity.Doctor;
import com.hospital.Repository.Interface.IBedRepository;
import com.hospital.Repository.Interface.IBloodBankRepository;
import com.hospital.Repository.Interface.IDiagnosisReportRepository;
import com.hospital.Repository.Interface.IHomeRepository;
import com.hospital.Response.ErrorMessages;
import com.hospital.Response.GlobalResponse;
import com.hospital.Response.ResponseData;
import com.hospital.Service.Interface.IBedService;
import com.hospital.Service.Interface.IHomeService;
import com.hospital.message.AppMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeService implements IHomeService {

    private IHomeRepository iHomeRepository;

    @Autowired
    public HomeService(IHomeRepository iHomeRepository) {
        this.iHomeRepository = iHomeRepository;
    }

    @Override
    public GlobalResponse getHomeInfo() {
        int allotedBeds = iHomeRepository.allotedBedsCount();
        int reportsToBeDelivered = iHomeRepository.reportsToBeDeliveredCount();
        int availablebloods = iHomeRepository.avaialableBloodsCount();

        GlobalResponse globalResponse = new GlobalResponse();
        ResponseData responseData = new ResponseData();

        HomeDTO homeDTO = new HomeDTO();
        homeDTO.setNoOfAllotedBeds(allotedBeds);
        homeDTO.setNoOfReportsToBeDelivered(reportsToBeDelivered);
        homeDTO.setNoOfAvailableBloodBags(availablebloods);

        responseData.setHomeDTO(homeDTO);
        globalResponse.setSuccess(true);
        globalResponse.setResponseData(responseData);

        return globalResponse;
    }
}