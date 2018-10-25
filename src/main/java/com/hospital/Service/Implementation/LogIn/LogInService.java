package com.hospital.Service.Implementation.LogIn;

import com.hospital.Entity.User;
import com.hospital.Repository.Interface.ILogInRepository;
import com.hospital.Response.ErrorMessages;
import com.hospital.Response.GlobalResponse;
import com.hospital.Response.ResponseData;
import com.hospital.Service.Base.BaseService;
import com.hospital.Service.Interface.ILogInService;
import com.hospital.message.AppMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogInService implements ILogInService {

    private ILogInRepository userRepository;

    @Autowired
    public LogInService(ILogInRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public GlobalResponse logIn(String email, String password) {
        User user = userRepository.login(email, password);
        GlobalResponse globalResponse = new GlobalResponse();
        ResponseData responseData = new ResponseData();
        ErrorMessages errorMessages = new ErrorMessages();

        if (user != null) {
            responseData.setUser(user);
            globalResponse.setSuccess(true);
            globalResponse.setResponseData(responseData);
        } else {
            globalResponse.setSuccess(false);
            errorMessages.setMessages(AppMessage.INVALID_LOGIN);
            globalResponse.setErrorMessages(errorMessages);
        }
        return globalResponse;
    }
}
