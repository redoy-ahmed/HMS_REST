package com.hospital.Service.Interface;

import com.hospital.Entity.BloodDonor;
import com.hospital.Response.GlobalResponse;

@org.springframework.stereotype.Service
public interface IBloodDonorService {

    GlobalResponse save(BloodDonor bloodDonor);

    GlobalResponse getBloodDonor(Integer bloodDonorId);

    GlobalResponse getBloodDonors();
}
