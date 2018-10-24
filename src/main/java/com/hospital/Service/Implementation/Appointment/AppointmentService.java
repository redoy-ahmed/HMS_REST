package com.hospital.Service.Implementation.Appointment;

import com.hospital.Entity.Appointment;
import com.hospital.Repository.Interface.IAppointmentRepository;
import com.hospital.Response.ErrorMessages;
import com.hospital.Response.GlobalResponse;
import com.hospital.Response.ResponseData;
import com.hospital.Service.Interface.IAppointmentService;
import com.hospital.message.AppMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService implements IAppointmentService {

    private IAppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentService(IAppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public GlobalResponse save(Appointment appointment) {
        appointment = appointmentRepository.save(appointment);
        GlobalResponse globalResponse = new GlobalResponse();
        ResponseData responseData = new ResponseData();

        responseData.setAppointment(appointment);
        globalResponse.setSuccess(true);
        globalResponse.setResponseData(responseData);
        return globalResponse;
    }

    @Override
    public GlobalResponse getAppointment(Integer appointmentId) {
        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElse(new Appointment());
        GlobalResponse globalResponse = new GlobalResponse();
        ResponseData responseData = new ResponseData();
        ErrorMessages errorMessages = new ErrorMessages();

        if (appointment.getAppointmentId() != null) {
            responseData.setAppointment(appointment);
            globalResponse.setSuccess(true);
            globalResponse.setResponseData(responseData);
        } else {
            globalResponse.setSuccess(false);
            errorMessages.setMessages(AppMessage.NO_APPOINTMENT_FOUND);
            globalResponse.setErrorMessages(errorMessages);
        }
        return globalResponse;
    }

    @Override
    public GlobalResponse getAppointments() {
        List<Appointment> appointmentList = appointmentRepository.findAll();
        GlobalResponse globalResponse = new GlobalResponse();
        ResponseData responseData = new ResponseData();
        ErrorMessages errorMessages = new ErrorMessages();

        if (appointmentList.size() > 0) {
            responseData.setAppointmentList(appointmentList);
            globalResponse.setSuccess(true);
            globalResponse.setResponseData(responseData);
        } else {
            globalResponse.setSuccess(false);
            errorMessages.setMessages(AppMessage.NO_APPOINTMENT_FOUND);
            globalResponse.setErrorMessages(errorMessages);
        }
        return globalResponse;
    }
}
