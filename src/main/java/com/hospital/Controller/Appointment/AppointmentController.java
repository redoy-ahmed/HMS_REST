package com.hospital.Controller.Appointment;

import com.hospital.Entity.Appointment;
import com.hospital.Response.GlobalResponse;
import com.hospital.Service.Interface.IAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AppointmentController {

    private IAppointmentService appointmentService;

    @Autowired
    public AppointmentController(IAppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping("/api/appointment/post")
    @ResponseBody
    public GlobalResponse save(@RequestBody Appointment appointment) {
        return appointmentService.save(appointment);
    }

    @GetMapping("/api/appointment/get/{appointment_id}")
    public GlobalResponse getAppointment(@PathVariable("appointment_id") Integer appointmentId) {
        return appointmentService.getAppointment(appointmentId);
    }

    @GetMapping("/api/appointment/getAll")
    public GlobalResponse getAllAppointments() {
        return appointmentService.getAppointments();
    }
}