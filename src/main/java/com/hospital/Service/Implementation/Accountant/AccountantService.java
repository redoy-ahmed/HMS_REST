package com.hospital.Service.Implementation.Accountant;

import com.hospital.Entity.Accountant;
import com.hospital.Exception.ExceptionHandler;
import com.hospital.Repository.Interface.IAccountantRepository;
import com.hospital.Response.ErrorMessages;
import com.hospital.Response.GlobalResponse;
import com.hospital.Response.ResponseData;
import com.hospital.Service.Base.BaseService;
import com.hospital.Service.Interface.IAccountantService;
import com.hospital.message.AppMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountantService extends BaseService implements IAccountantService {

    private IAccountantRepository accountantRepository;

    @Autowired
    public AccountantService(IAccountantRepository accountantRepository) {
        this.accountantRepository = accountantRepository;
    }

    @Override
    public GlobalResponse save(Accountant accountant) {
        accountant = accountantRepository.save(accountant);
        ResponseData responseData = new ResponseData();
        responseData.setAccountant(accountant);
        globalResponse.setSuccess(true);
        globalResponse.setResponseData(responseData);
        return globalResponse;
    }

    @Override
    public GlobalResponse getAccountant(Integer accountantId) {
        Accountant accountant = accountantRepository.findById(accountantId)
                .orElse(new Accountant());
        ResponseData responseData = new ResponseData();
        ErrorMessages errorMessages = new ErrorMessages();

        if (accountant.getAccountantId() != null) {
            responseData.setAccountant(accountant);
            globalResponse.setSuccess(true);
            globalResponse.setResponseData(responseData);
        } else {
            globalResponse.setSuccess(false);
            errorMessages.setMessages(AppMessage.NO_ACCOUNTANT_FOUND);
            globalResponse.setErrorMessages(errorMessages);
        }
        return globalResponse;
    }
}
