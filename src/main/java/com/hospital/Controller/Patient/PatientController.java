package com.hospital.Controller.Patient;

import com.hospital.Entity.Patient;
import com.hospital.Response.GlobalResponse;
import com.hospital.Service.Interface.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    public ResponseEntity<GlobalResponse> getAllPatients() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("test", "test");
        return ResponseEntity.accepted().headers(headers).body(patientService.getPatients());
    }

    @GetMapping("/api/patient/getAlll")
    public ResponseEntity<GlobalResponse> getAll(@RequestHeader HttpHeaders headers, HttpServletResponse httpServletResponse) {
        httpServletResponse.addHeader("test1", "test1");
        GlobalResponse globalResponse = patientService.getPatients();
        return ResponseEntity.accepted().body(globalResponse);
    }
}
