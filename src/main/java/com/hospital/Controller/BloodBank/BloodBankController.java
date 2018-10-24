package com.hospital.Controller.BloodBank;

import com.hospital.Entity.BloodBank;
import com.hospital.Response.GlobalResponse;
import com.hospital.Service.Interface.IBloodBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BloodBankController {

    private IBloodBankService bloodBankService;

    @Autowired
    public BloodBankController(IBloodBankService bloodBankService) {
        this.bloodBankService = bloodBankService;
    }

    @PostMapping("/api/bloodGroup/post")
    @ResponseBody
    public GlobalResponse save(@RequestBody BloodBank bloodBank) {
        return bloodBankService.save(bloodBank);
    }

    @GetMapping("/api/bloodGroup/get/{blood_group_id}")
    public GlobalResponse getBloodGroup(@PathVariable("blood_group_id") Integer bloodGroupId) {
        return bloodBankService.getBloodGroup(bloodGroupId);
    }

    @GetMapping("/api/bloodGroup/getAll")
    public GlobalResponse getAllBloodGroups() {
        return bloodBankService.getBloodGroups();
    }
}
