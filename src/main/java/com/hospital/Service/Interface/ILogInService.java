package com.hospital.Service.Interface;

import com.hospital.Entity.User;
import com.hospital.Response.GlobalResponse;

@org.springframework.stereotype.Service
public interface ILogInService {

    GlobalResponse logIn(String email, String password);

    void updateToken(User user);

    String getToken(String token);
}
