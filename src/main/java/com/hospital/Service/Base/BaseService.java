package com.hospital.Service.Base;

import com.hospital.Response.GlobalResponse;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseService {

    @Autowired
    protected GlobalResponse globalResponse;
}
