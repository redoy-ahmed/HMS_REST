package com.hospital.Repository.Implementation;

import com.hospital.Dto.HomeDTO;
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
    public int avaialableBloodsCount() {
        Query query = entityManager.createNativeQuery("select count(status) from blood_bank");
        return query.getFirstResult();
    }
}
