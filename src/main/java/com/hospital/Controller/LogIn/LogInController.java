package com.hospital.Controller.LogIn;

import com.hospital.Entity.User;
import com.hospital.Response.GlobalResponse;
import com.hospital.Service.Interface.ILogInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LogInController {

    private ILogInService logInService;

    @Autowired
    public LogInController(ILogInService logInService) {
        this.logInService = logInService;
    }

    @PostMapping("/api/login")
    @ResponseBody
    public GlobalResponse login(@RequestBody User user) {
        return logInService.logIn(user.getEmail(),user.getPassword());
    }
}
