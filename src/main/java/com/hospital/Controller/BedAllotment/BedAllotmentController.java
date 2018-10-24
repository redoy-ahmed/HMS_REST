package com.hospital.Controller.BedAllotment;

import com.hospital.Entity.BedAllotment;
import com.hospital.Response.GlobalResponse;
import com.hospital.Service.Interface.IBedAllotmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BedAllotmentController {

    private IBedAllotmentService bedAllotmentService;

    @Autowired
    public BedAllotmentController(IBedAllotmentService bedAllotmentService) {
        this.bedAllotmentService = bedAllotmentService;
    }

    @PostMapping("/api/bedAllotment/post")
    @ResponseBody
    public GlobalResponse save(@RequestBody BedAllotment bedAllotment) {
        return bedAllotmentService.save(bedAllotment);
    }

    @GetMapping("/api/bedAllotment/get/{bed_allotment_id}")
    public GlobalResponse getBed(@PathVariable("bed_allotment_id") Integer bedAllotmentId) {
        return bedAllotmentService.getBedAllotment(bedAllotmentId);
    }

    @GetMapping("/api/bedAllotment/getAll")
    public GlobalResponse getAllBeds() {
        return bedAllotmentService.getBedAllotments();
    }
}
