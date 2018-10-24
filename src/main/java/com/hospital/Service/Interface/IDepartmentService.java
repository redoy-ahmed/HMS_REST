package com.hospital.Service.Interface;

import com.hospital.Entity.Department;
import com.hospital.Response.GlobalResponse;

@org.springframework.stereotype.Service
public interface IDepartmentService {

    GlobalResponse save(Department department);

    GlobalResponse getDepartment(Integer departmentId);

    GlobalResponse getDepartments();
}
