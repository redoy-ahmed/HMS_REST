package com.hospital.Service.Interface;

import com.hospital.Entity.Appointment;
import com.hospital.Response.GlobalResponse;

@org.springframework.stereotype.Service
public interface IAppointmentService {

    GlobalResponse save(Appointment appointment);

    GlobalResponse getAppointment(Integer appointmentId);

    GlobalResponse getAppointments();
}
