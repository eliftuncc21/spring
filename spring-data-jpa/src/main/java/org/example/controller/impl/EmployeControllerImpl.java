package org.example.controller.impl;

import lombok.RequiredArgsConstructor;
import org.example.controller.IEmployeController;
import org.example.dto.EmployeeResponseDto;
import org.example.services.IEmployeeServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "rest/api/employee")
@RequiredArgsConstructor
public class EmployeControllerImpl implements IEmployeController {

    private final IEmployeeServices employeeServices;

    @GetMapping(path = "/list")
    @Override
    public List<EmployeeResponseDto> getEmployee() {
        return employeeServices.getEmployee();
    }
}
