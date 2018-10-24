package com.hospital.Service.Interface;

import com.hospital.Entity.BloodBank;
import com.hospital.Response.GlobalResponse;

@org.springframework.stereotype.Service
public interface IBloodBankService {

    GlobalResponse save(BloodBank bloodBank);

    GlobalResponse getBloodGroup(Integer bloodGroupId);

    GlobalResponse getBloodGroups();
}
