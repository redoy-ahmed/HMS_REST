package com.hospital.Controller.Accountant;

import com.hospital.Entity.Accountant;
import com.hospital.Response.GlobalResponse;
import com.hospital.Service.Interface.IAccountantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountantController {

    private IAccountantService accountantService;

    @Autowired
    public AccountantController(IAccountantService accountantService) {
        this.accountantService = accountantService;
    }

    @PostMapping("/api/accountant/post")
    @ResponseBody
    public GlobalResponse save(@RequestBody Accountant accountant) {
        return accountantService.save(accountant);
    }

    @GetMapping("/api/accountant/get/{accountant_id}")
    public GlobalResponse getAccountant(@PathVariable("accountant_id") Integer accountantId) {
        return accountantService.getAccountant(accountantId);
    }
}
