package org.example.controller;

import org.example.model.Employee;
import java.util.*;

import org.example.model.UpdateEmployeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.example.services.EmployeeService;

@RestController
@RequestMapping("/rest/api/employee")
public class RestEmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(path = "/list")
    public List<Employee> getAllEmployeeList(){
        return employeeService.getAllEmployeeList();
    }

    @GetMapping(path = "/list/{id}")
    public Employee getEmployeeById(@PathVariable(name = "id", required = true) int id){
        return employeeService.getEmployeeById(id);
    }

    @GetMapping(path = "/with-params")
    public List<Employee> getEmployeeWithParams(@RequestParam(name = "firstName", required = false) String firstName,
                                          @RequestParam(name = "lastName", required = false) String lastName){
        System.out.println(firstName + " " + lastName);
        return employeeService.getEmployeeWithParams(firstName, lastName);
    }

    @PostMapping(path = "/save-employee")
    public Employee saveEmployee(@RequestBody Employee newEmployee){
        return employeeService.saveEmployee(newEmployee);
    }

    @DeleteMapping(path = "/delete-employee/{id}")
    public boolean deleteEmployee(@PathVariable(name = "id", required = true) int id){
        return employeeService.deleteEmployee(id);
    }

    @PutMapping(path = "/update-employee/{id}")
    public Employee updateEmployee(@PathVariable(name = "id") int id, @RequestBody UpdateEmployeRequest request){
        return employeeService.updateEmployee(id, request);
    }

    @GetMapping(path = "/with-department")
    public List<Employee> getEmployeeWithDepartment(@RequestParam(name = "department", required = true) String department){
        return employeeService.getEmployeeWithDepartment(department);
    }

    @GetMapping(path = "/age")
    public List<Employee> findEmployeesByAge(@RequestParam(name = "age", required = true) int age){
        return employeeService.findEmployeesByAge(age);
    }

}