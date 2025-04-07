package org.example.services.impl;

import lombok.RequiredArgsConstructor;
import org.example.dto.EmployeeResponseDto;
import org.example.dto.department.DepartmentResponseDto;
import org.example.entities.Employee;
import org.example.repository.EmployeeRepository;
import org.example.services.IEmployeeServices;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServicesImpl implements IEmployeeServices {

    private final EmployeeRepository employeeRepository;

    @Override
    public List<EmployeeResponseDto> getEmployee() {
        List<EmployeeResponseDto> employeeResponseDtoList = new ArrayList<>();
        List<Employee> employeeList = employeeRepository.findAll();
        for(Employee employee : employeeList){
            EmployeeResponseDto employeeResponseDto = new EmployeeResponseDto();
            BeanUtils.copyProperties(employee, employeeResponseDto);

            employeeResponseDto.setDepartment(new DepartmentResponseDto(employee.getId(), employee.getDepartment().getDepartmentName()));

            employeeResponseDtoList.add(employeeResponseDto);
        }
        return employeeResponseDtoList;
    }
}
