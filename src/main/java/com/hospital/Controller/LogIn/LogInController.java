package com.hospital.Controller.LogIn;

import com.hospital.Entity.User;
import com.hospital.Response.GlobalResponse;
import com.hospital.Security.jwt.TokenProvider;
import com.hospital.Service.Interface.ILogInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
public class LogInController {

    private AuthenticationManager authenticationManager;
    private TokenProvider jwtTokenUtil;
    private ILogInService logInService;

    @Autowired
    public LogInController(ILogInService logInService, AuthenticationManager authenticationManager, TokenProvider jwtTokenUtil) {
        this.logInService = logInService;
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @RequestMapping(value = "/api/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<GlobalResponse> login(User user) throws AuthenticationException {
        GlobalResponse globalResponse = authenticateUser(user.getUsername(), user.getPassword());
        if (globalResponse.isSuccess()) {
            User loggedUser = globalResponse.getResponseData().getUser();

            final Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);

            final String token = jwtTokenUtil.generateToken(authentication);

            loggedUser.setToken(token);
            logInService.updateToken(loggedUser);

            return ResponseEntity.accepted().body(globalResponse);
        } else {
            return ResponseEntity.badRequest().body(globalResponse);
        }
    }

    private GlobalResponse authenticateUser(String name, String password) {
        return logInService.logIn(name, password);
    }
}
