package com.hospital.Repository.Interface;

public interface IHomeRepository {

    int allotedBedsCount();
    int reportsToBeDeliveredCount();
    int availableBloodsCount();

    int totalDoctorsAvailable();
    int doctorsAvailableInDept1();
    int doctorsAvailableInDept2();
    int doctorsAvailableInDept3();
    int doctorsAvailableInDept4();

    int totalAppointedPatients();
    int patientsAppointedInDept1();
    int patientsAppointedInDept2();
    int patientsAppointedInDept3();
    int patientsAppointedInDept4();
}
