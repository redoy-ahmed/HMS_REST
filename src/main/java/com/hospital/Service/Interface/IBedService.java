package com.hospital.Service.Interface;

import com.hospital.Entity.Bed;
import com.hospital.Response.GlobalResponse;

@org.springframework.stereotype.Service
public interface IBedService {

    GlobalResponse save(Bed bed);

    GlobalResponse getBed(Integer bedId);

    GlobalResponse getBeds();
}
