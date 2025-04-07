package org.example.services;

import org.example.dto.EmployeeResponseDto;

import java.util.List;

public interface IEmployeeServices {
    public List<EmployeeResponseDto> getEmployee();
}
