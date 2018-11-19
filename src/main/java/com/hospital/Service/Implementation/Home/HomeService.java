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
        int allottedBeds = iHomeRepository.allotedBedsCount();
        int reportsToBeDelivered = iHomeRepository.reportsToBeDeliveredCount();
        int availableBloods = iHomeRepository.availableBloodsCount();

        int totalDoctorsAvailable = iHomeRepository.totalDoctorsAvailable();
        int doctorsAvailableInDept1 = iHomeRepository.doctorsAvailableInDept1();
        int doctorsAvailableInDept2 = iHomeRepository.doctorsAvailableInDept2();
        int doctorsAvailableInDept3 = iHomeRepository.doctorsAvailableInDept3();
        int doctorsAvailableInDept4 = iHomeRepository.doctorsAvailableInDept4();

        int totalAppointedPatients = iHomeRepository.totalAppointedPatients();
        int patientsAppointedInDept1 = iHomeRepository.patientsAppointedInDept1();
        int patientsAppointedInDept2 = iHomeRepository.patientsAppointedInDept2();
        int patientsAppointedInDept3 = iHomeRepository.patientsAppointedInDept3();
        int patientsAppointedInDept4 = iHomeRepository.patientsAppointedInDept4();

        GlobalResponse globalResponse = new GlobalResponse();
        ResponseData responseData = new ResponseData();

        HomeDTO homeDTO = new HomeDTO();
        homeDTO.setNoOfAllottedBeds(allottedBeds);
        homeDTO.setNoOfReportsToBeDelivered(reportsToBeDelivered);
        homeDTO.setNoOfAvailableBloodBags(availableBloods);

        homeDTO.setNoOfTotalDoctors(totalDoctorsAvailable);
        homeDTO.setNoOfDoctorsInDept1(doctorsAvailableInDept1);
        homeDTO.setNoOfDoctorsInDept2(doctorsAvailableInDept2);
        homeDTO.setNoOfDoctorsInDept3(doctorsAvailableInDept3);
        homeDTO.setNoOfDoctorsInDept4(doctorsAvailableInDept4);

        homeDTO.setNoOfTotalAppointedPatients(totalAppointedPatients);
        homeDTO.setNoOfAppointedPatientsInDept1(patientsAppointedInDept1);
        homeDTO.setNoOfAppointedPatientsInDept2(patientsAppointedInDept2);
        homeDTO.setNoOfAppointedPatientsInDept3(patientsAppointedInDept3);
        homeDTO.setNoOfAppointedPatientsInDept4(patientsAppointedInDept4);

        responseData.setHomeDTO(homeDTO);
        globalResponse.setSuccess(true);
        globalResponse.setResponseData(responseData);

        return globalResponse;
    }
}