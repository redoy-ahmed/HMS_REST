package com.hospital.Controller.Department;

import com.hospital.Entity.Department;
import com.hospital.Response.GlobalResponse;
import com.hospital.Service.Interface.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DepartmentController {

    private IDepartmentService departmentService;

    @Autowired
    public DepartmentController(IDepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("/api/department/post")
    @ResponseBody
    public GlobalResponse save(@RequestBody Department department) {
        return departmentService.save(department);
    }

    @GetMapping("/api/department/get/{department_id}")
    public GlobalResponse getDepartment(@PathVariable("department_id") Integer departmentId) {
        return departmentService.getDepartment(departmentId);
    }

    @GetMapping("/api/department/getAll")
    public GlobalResponse getAllDepartments() {
        return departmentService.getDepartments();
    }
}
