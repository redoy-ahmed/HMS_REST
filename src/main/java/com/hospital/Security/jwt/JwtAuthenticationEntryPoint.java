package com.hospital.Security.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hospital.Response.ErrorMessages;
import com.hospital.Response.GlobalResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint, Serializable {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {

        GlobalResponse globalResponse = new GlobalResponse();
        ErrorMessages errorMessages = new ErrorMessages();
        errorMessages.setMessages("Unauthorized");
        globalResponse.setSuccess(false);
        globalResponse.setErrorMessages(errorMessages);
        String json = new ObjectMapper().writeValueAsString(globalResponse);
        response.getWriter().write(json);
        response.flushBuffer();
        //response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
    }
}