package org.example.controller;

import org.example.dto.EmployeeResponseDto;

import java.util.List;

public interface IEmployeController {
    List<EmployeeResponseDto> getEmployee();
}
