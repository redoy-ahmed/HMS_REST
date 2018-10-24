package com.hospital.Service.Implementation.DiagnosisReport;

import com.hospital.Entity.DiagnosisReport;
import com.hospital.Repository.Interface.IDiagnosisReportRepository;
import com.hospital.Response.ErrorMessages;
import com.hospital.Response.GlobalResponse;
import com.hospital.Response.ResponseData;
import com.hospital.Service.Interface.IDiagnosisReportService;
import com.hospital.message.AppMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiagnosisReportService implements IDiagnosisReportService {

    private IDiagnosisReportRepository diagnosisReportRepository;

    @Autowired
    public DiagnosisReportService(IDiagnosisReportRepository diagnosisReportRepository) {
        this.diagnosisReportRepository = diagnosisReportRepository;
    }

    @Override
    public GlobalResponse save(DiagnosisReport diagnosisReport) {
        diagnosisReport = diagnosisReportRepository.save(diagnosisReport);
        GlobalResponse globalResponse = new GlobalResponse();
        ResponseData responseData = new ResponseData();

        responseData.setDiagnosisReport(diagnosisReport);
        globalResponse.setSuccess(true);
        globalResponse.setResponseData(responseData);
        return globalResponse;
    }

    @Override
    public GlobalResponse getDiagnosisReport(Integer diagnosisReportId) {
        DiagnosisReport diagnosisReport = diagnosisReportRepository.getOne(diagnosisReportId);
        GlobalResponse globalResponse = new GlobalResponse();
        ResponseData responseData = new ResponseData();
        ErrorMessages errorMessages = new ErrorMessages();

        if (diagnosisReport.getDiagnosisReportId() != null) {
            responseData.setDiagnosisReport(diagnosisReport);
            globalResponse.setSuccess(true);
            globalResponse.setResponseData(responseData);
        } else {
            globalResponse.setSuccess(false);
            errorMessages.setMessages(AppMessage.NO_DIAGNOSIS_REPORT_FOUND);
            globalResponse.setErrorMessages(errorMessages);
        }
        return globalResponse;
    }

    @Override
    public GlobalResponse getDiagnosisReports() {
        List<DiagnosisReport> diagnosisReportList = diagnosisReportRepository.findAll();
        GlobalResponse globalResponse = new GlobalResponse();
        ResponseData responseData = new ResponseData();
        ErrorMessages errorMessages = new ErrorMessages();

        if (diagnosisReportList.size() > 0) {
            responseData.setDiagnosisReportList(diagnosisReportList);
            globalResponse.setSuccess(true);
            globalResponse.setResponseData(responseData);
        } else {
            globalResponse.setSuccess(false);
            errorMessages.setMessages(AppMessage.NO_DIAGNOSIS_REPORT_FOUND);
            globalResponse.setErrorMessages(errorMessages);
        }
        return globalResponse;
    }
}
