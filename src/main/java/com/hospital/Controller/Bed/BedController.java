package com.hospital.Controller.Bed;

import com.hospital.Entity.Bed;
import com.hospital.Response.GlobalResponse;
import com.hospital.Service.Interface.IBedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BedController {

    private IBedService bedService;

    @Autowired
    public BedController(IBedService bedService) {
        this.bedService = bedService;
    }

    @PostMapping("/api/bed/post")
    @ResponseBody
    public GlobalResponse save(@RequestBody Bed bed) {
        return bedService.save(bed);
    }

    @GetMapping("/api/bed/get/{bed_id}")
    public GlobalResponse getBed(@PathVariable("bed_id") Integer bedId) {
        return bedService.getBed(bedId);
    }

    @GetMapping("/api/bed/getAll")
    public GlobalResponse getAllBeds() {
        return bedService.getBeds();
    }
}
