package com.hospital.Service.Interface;

import com.hospital.Entity.Accountant;
import com.hospital.Response.GlobalResponse;

@org.springframework.stereotype.Service
public interface IAccountantService {

    GlobalResponse save(Accountant accountant);

    GlobalResponse getAccountant(Integer accountantId);
}
