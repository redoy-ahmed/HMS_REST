package com.hospital.Service.Interface;

import com.hospital.Response.GlobalResponse;

@org.springframework.stereotype.Service
public interface IHomeService {

    GlobalResponse getHomeInfo();
}