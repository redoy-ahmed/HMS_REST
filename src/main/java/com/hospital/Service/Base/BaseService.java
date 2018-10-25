package com.hospital.Service.Base;

import com.hospital.Response.ErrorMessages;
import com.hospital.Response.GlobalResponse;
import com.hospital.Response.Messages;
import com.hospital.Response.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseService {

    @Autowired
    protected GlobalResponse globalResponse;
}
