package com.hospital.Service.Implementation.Department;

import com.hospital.Entity.Department;
import com.hospital.Repository.Interface.IDepartmentRepository;
import com.hospital.Response.ErrorMessages;
import com.hospital.Response.GlobalResponse;
import com.hospital.Response.ResponseData;
import com.hospital.Service.Base.BaseService;
import com.hospital.Service.Interface.IDepartmentService;
import com.hospital.message.AppMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService extends BaseService implements IDepartmentService {

    private IDepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(IDepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public GlobalResponse save(Department department) {
        department = departmentRepository.save(department);
        ResponseData responseData = new ResponseData();
        responseData.setDepartment(department);
        globalResponse.setSuccess(true);
        globalResponse.setResponseData(responseData);
        return globalResponse;
    }

    @Override
    public GlobalResponse getDepartment(Integer departmentId) {
        Department department = departmentRepository.findById(departmentId)
                .orElse(new Department());

        ResponseData responseData = new ResponseData();
        ErrorMessages errorMessages = new ErrorMessages();
        if (department.getDepartmentId() != null) {
            responseData.setDepartment(department);
            globalResponse.setSuccess(true);
            globalResponse.setResponseData(responseData);
        } else {
            globalResponse.setSuccess(false);
            errorMessages.setMessages(AppMessage.NO_DEPARTMENT_FOUND);
            globalResponse.setErrorMessages(errorMessages);
        }
        return globalResponse;
    }

    @Override
    public GlobalResponse getDepartments() {
        List<Department> departmentList = departmentRepository.findAll();

        ResponseData responseData = new ResponseData();
        ErrorMessages errorMessages = new ErrorMessages();
        if (departmentList.size() > 0) {
            responseData.setDepartmentList(departmentList);
            globalResponse.setSuccess(true);
            globalResponse.setResponseData(responseData);
        } else {
            globalResponse.setSuccess(false);
            errorMessages.setMessages(AppMessage.NO_DEPARTMENT_FOUND);
            globalResponse.setErrorMessages(errorMessages);
        }
        return globalResponse;
    }
}
