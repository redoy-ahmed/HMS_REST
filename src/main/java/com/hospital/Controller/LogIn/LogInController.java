package com.hospital.Controller.LogIn;

import com.hospital.Entity.User;
import com.hospital.Response.GlobalResponse;
import com.hospital.Security.Token.ITokenGenerator;
import com.hospital.Service.Interface.ILogInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LogInController {

    private ILogInService logInService;
    private ITokenGenerator tokenGenerator;

    @Autowired
    public LogInController(ILogInService logInService, ITokenGenerator tokenGenerator) {
        this.logInService = logInService;
        this.tokenGenerator = tokenGenerator;
    }

    @PostMapping("/api/login")
    @ResponseBody
    public ResponseEntity<GlobalResponse> login(@RequestBody User user) {
        GlobalResponse globalResponse = authenticateUser(user.getEmail(), user.getPassword());

        if (globalResponse.isSuccess()) {
            HttpHeaders headers = new HttpHeaders();
            headers.add("token", tokenGenerator.issueToken());
            return ResponseEntity.accepted().headers(headers).body(globalResponse);
        } else {
            return ResponseEntity.badRequest().body(globalResponse);
        }
    }

    private GlobalResponse authenticateUser(String email, String password) {
        return logInService.logIn(email, password);
    }
}
