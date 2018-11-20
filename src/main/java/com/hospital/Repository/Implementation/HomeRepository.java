package com.hospital.Repository.Implementation;

import com.hospital.Repository.Interface.IHomeRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Repository
public class HomeRepository implements IHomeRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public int allotedBedsCount() {
        Query query = entityManager.createNativeQuery("select count(a.bed_id) from bed a\n" +
                "inner join bed_allotment b on a.bed_id = b.bed_id\n" +
                "where b.discharge_timestamp IS NULL");
        return query.getFirstResult();
    }

    @Override
    public int reportsToBeDeliveredCount() {
        Query query = entityManager.createNativeQuery("select count(diagnosis_report_id) from diagnosis_report");
        return query.getFirstResult();
    }

    @Override
    public int availableBloodsCount() {
        Query query = entityManager.createNativeQuery("select count(status) from blood_bank");
        return query.getFirstResult();
    }

    @Override
    public int totalDoctorsAvailable() {
        Query query = entityManager.createNativeQuery("select count(doctor_id) from doctor");
        return query.getFirstResult();
    }

    @Override
    public int doctorsAvailableInDept1() {
        Query query = entityManager.createNativeQuery("select count(doctor_id) from doctor where department_id = 1");
        return query.getFirstResult();
    }

    @Override
    public int doctorsAvailableInDept2() {
        Query query = entityManager.createNativeQuery("select count(doctor_id) from doctor where department_id = 2");
        return query.getFirstResult();
    }

    @Override
    public int doctorsAvailableInDept3() {
        Query query = entityManager.createNativeQuery("select count(doctor_id) from doctor where department_id = 3");
        return query.getFirstResult();
    }

    @Override
    public int doctorsAvailableInDept4() {
        Query query = entityManager.createNativeQuery("select count(doctor_id) from doctor where department_id = 4");
        return query.getFirstResult();
    }

    @Override
    public int totalAppointedPatients() {
        Query query = entityManager.createNativeQuery("select count(appointment_id) from appointment");
        return query.getFirstResult();
    }

    @Override
    public int patientsAppointedInDept1() {
        Query query = entityManager.createNativeQuery("select count(appointment_id) from appointment as a\n" +
                "inner join patient as b on a.patient_id = b.patient_id\n" +
                "where b.department_id = 1");
        return query.getFirstResult();
    }

    @Override
    public int patientsAppointedInDept2() {
        Query query = entityManager.createNativeQuery("select count(appointment_id) from appointment as a\n" +
                "inner join patient as b on a.patient_id = b.patient_id\n" +
                "where b.department_id = 2");
        return query.getFirstResult();
    }

    @Override
    public int patientsAppointedInDept3() {
        Query query = entityManager.createNativeQuery("select count(appointment_id) from appointment as a\n" +
                "inner join patient as b on a.patient_id = b.patient_id\n" +
                "where b.department_id = 3");
        return query.getFirstResult();
    }

    @Override
    public int patientsAppointedInDept4() {
        Query query = entityManager.createNativeQuery("select count(appointment_id) from appointment as a\n" +
                "inner join patient as b on a.patient_id = b.patient_id\n" +
                "where b.department_id = 4");
        return query.getFirstResult();
    }
}
