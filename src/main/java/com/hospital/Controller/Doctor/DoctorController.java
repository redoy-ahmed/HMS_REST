package com.hospital.Controller.Doctor;

import com.hospital.Entity.Doctor;
import com.hospital.Response.GlobalResponse;
import com.hospital.Service.Interface.IDoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DoctorController {

    private IDoctorService doctorService;

    @Autowired
    public DoctorController(IDoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping("/api/doctor/post")
    @ResponseBody
    public GlobalResponse save(@RequestBody Doctor doctor) {
        return doctorService.save(doctor);
    }

    @GetMapping("/api/doctor/get/{doctor_id}")
    public GlobalResponse getDoctor(@PathVariable("doctor_id") Integer doctorId) {
        return doctorService.getDoctor(doctorId);
    }

    @GetMapping("/api/doctor/getAll")
    public GlobalResponse getAllDoctors() {
        return doctorService.getDoctors();
    }
}
