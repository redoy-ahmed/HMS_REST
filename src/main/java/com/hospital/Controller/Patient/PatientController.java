package com.hospital.Controller.Patient;

import com.hospital.Entity.Doctor;
import com.hospital.Entity.Patient;
import com.hospital.Response.GlobalResponse;
import com.hospital.Service.Interface.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PatientController {

    private IPatientService patientService;

    @Autowired
    public PatientController(IPatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping("/api/patient/post")
    @ResponseBody
    public GlobalResponse save(@RequestBody Patient patient) {
        return patientService.save(patient);
    }

    @GetMapping("/api/patient/get/{patient_id}")
    public GlobalResponse getPatient(@PathVariable("patient_id") Integer patientId) {
        return patientService.getPatient(patientId);
    }

    @GetMapping("/api/patient/getAll")
    public GlobalResponse getAllPatients() {
        return patientService.getPatients();
    }
}
