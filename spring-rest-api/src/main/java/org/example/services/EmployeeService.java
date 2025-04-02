package org.example.services;

import org.example.model.Employee;
import java.util.List;

import org.example.model.UpdateEmployeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployeeList(){
        return employeeRepository.getAllEmployeeList();
    }

    public Employee getEmployeeById(int id){
        return employeeRepository.getEmployeeById(id);
    }

    public List<Employee> getEmployeeWithParams(String firstName, String lastName){
        return employeeRepository.getEmployeeWithParams(firstName, lastName);
    }

    public Employee saveEmployee(Employee newEmployee){
        return employeeRepository.saveEmployee(newEmployee);
    }

    public boolean deleteEmployee(int id){
        return employeeRepository.deleteEmployee(id);
    }

    public Employee updateEmployee(int id, UpdateEmployeRequest request){
        return employeeRepository.updateEmployee(id, request);
    }

    public List<Employee> getEmployeeWithDepartment(String department){
        return employeeRepository.getEmployeeWithDepartment(department);
    }

    public List<Employee> findEmployeesByAge(int age){
        return employeeRepository.findEmployeesByAge(age);
    }
}
