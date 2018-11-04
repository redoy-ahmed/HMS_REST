package com.hospital.Service.Interface;

import com.hospital.Entity.User;
import com.hospital.Response.GlobalResponse;

@org.springframework.stereotype.Service(value = "userService")
public interface ILogInService {

    GlobalResponse logIn(String name, String password);

    void updateToken(User user);

    String getToken(String token);
}
