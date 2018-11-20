package com.hospital.Service.Implementation.Home;

import com.hospital.Dto.Home;
import com.hospital.Repository.Interface.IHomeRepository;
import com.hospital.Response.GlobalResponse;
import com.hospital.Response.ResponseData;
import com.hospital.Service.Interface.IHomeService;
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

        Home home = new Home();
        home.setNoOfAllottedBeds(allottedBeds);
        home.setNoOfReportsToBeDelivered(reportsToBeDelivered);
        home.setNoOfAvailableBloodBags(availableBloods);

        home.setNoOfTotalDoctors(totalDoctorsAvailable);
        home.setNoOfDoctorsInDept1(doctorsAvailableInDept1);
        home.setNoOfDoctorsInDept2(doctorsAvailableInDept2);
        home.setNoOfDoctorsInDept3(doctorsAvailableInDept3);
        home.setNoOfDoctorsInDept4(doctorsAvailableInDept4);

        home.setNoOfTotalAppointedPatients(totalAppointedPatients);
        home.setNoOfAppointedPatientsInDept1(patientsAppointedInDept1);
        home.setNoOfAppointedPatientsInDept2(patientsAppointedInDept2);
        home.setNoOfAppointedPatientsInDept3(patientsAppointedInDept3);
        home.setNoOfAppointedPatientsInDept4(patientsAppointedInDept4);

        responseData.setHome(home);
        globalResponse.setSuccess(true);
        globalResponse.setResponseData(responseData);

        return globalResponse;
    }
}