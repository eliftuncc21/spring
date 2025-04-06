package org.example.services.impl;

import org.example.dto.DtoEmployee;
import org.example.dto.department.DtoDepartment;
import org.example.entities.Employee;
import org.example.repository.EmployeeRepository;
import org.example.services.IEmployeeServices;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServicesImpl implements IEmployeeServices {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<DtoEmployee> getEmployee() {
        List<DtoEmployee> dtoEmployeeList = new ArrayList<>();
        List<Employee> employeeList = employeeRepository.findAll();
        for(Employee employee : employeeList){
            DtoEmployee dtoEmployee = new DtoEmployee();
            BeanUtils.copyProperties(employee, dtoEmployee);

            dtoEmployee.setDepartment(new DtoDepartment(employee.getId(), employee.getDepartment().getDepartmentName()));

            dtoEmployeeList.add(dtoEmployee);
        }
        return dtoEmployeeList;
    }
}
