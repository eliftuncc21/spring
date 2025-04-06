package org.example.controller.impl;

import org.example.controller.IEmployeController;
import org.example.dto.DtoEmployee;
import org.example.services.impl.EmployeeServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "rest/api/employee")
public class EmployeControllerImpl implements IEmployeController {

    @Autowired
    private EmployeeServicesImpl employeeServices;

    @GetMapping(path = "/list")
    @Override
    public List<DtoEmployee> getEmployee() {
        return employeeServices.getEmployee();
    }
}
