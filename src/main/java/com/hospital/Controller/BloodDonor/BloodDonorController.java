package com.hospital.Controller.BloodDonor;

import com.hospital.Entity.BloodDonor;
import com.hospital.Response.GlobalResponse;
import com.hospital.Service.Interface.IBloodDonorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BloodDonorController {

    private IBloodDonorService bloodDonorService;

    @Autowired
    public BloodDonorController(IBloodDonorService bloodDonorService) {
        this.bloodDonorService = bloodDonorService;
    }

    @PostMapping("/api/bloodDonor/post")
    @ResponseBody
    public GlobalResponse save(@RequestBody BloodDonor bloodDonor) {
        return bloodDonorService.save(bloodDonor);
    }

    @GetMapping("/api/bloodDonor/get/{blood_donor_id}")
    public GlobalResponse getBloodDonor(@PathVariable("blood_donor_id") Integer bloodDonorId) {
        return bloodDonorService.getBloodDonor(bloodDonorId);
    }

    @GetMapping("/api/bloodDonor/getAll")
    public GlobalResponse getAllBloodDonors() {
        return bloodDonorService.getBloodDonors();
    }
}
