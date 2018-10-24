package com.hospital.Service.Interface;

import com.hospital.Entity.BedAllotment;
import com.hospital.Response.GlobalResponse;

@org.springframework.stereotype.Service
public interface IBedAllotmentService {

    GlobalResponse save(BedAllotment bedAllotment);

    GlobalResponse getBedAllotment(Integer bedAllotmentId);

    GlobalResponse getBedAllotments();
}
