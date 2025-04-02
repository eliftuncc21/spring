package org.example.repository;

import org.example.model.Employee;
import org.example.model.UpdateEmployeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepository {

    @Autowired
    private List<Employee> employeeList;

    public List<Employee> getAllEmployeeList(){
        return employeeList;
    }

    public Employee getEmployeeById(int id) {
        try{
            Employee findEmployee = null;
            for (Employee employee : employeeList){
                if(id == employee.getId()){
                    findEmployee = employee;
                }
            }
            return findEmployee;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public List<Employee> getEmployeeWithParams(String firstName, String lastName){
        List<Employee> employeeWithParams = new ArrayList<>();

        if (firstName == null && lastName == null)
            return employeeList;
        for (Employee employee : employeeList){
            if(firstName != null && lastName != null){
                if(employee.getFirstName().equalsIgnoreCase(firstName) && employee.getLastName().equalsIgnoreCase(lastName)){
                    employeeWithParams.add(employee);
                }
            }
            if(firstName == null && lastName != null){
                if(employee.getLastName().equalsIgnoreCase(lastName)){
                    employeeWithParams.add(employee);
                }
            }
            if(firstName != null && lastName == null){
                if(employee.getFirstName().equalsIgnoreCase(firstName)){
                    employeeWithParams.add(employee);
                }
            }
        }
        return employeeWithParams;
    }

    public Employee saveEmployee(Employee newEmployee){
        employeeList.add(newEmployee);
        return newEmployee;
    }

    public boolean deleteEmployee(int id){
        try{
            Employee findEmployee = null;
            for (Employee employee : employeeList){
                if(id == employee.getId()){
                    findEmployee = employee;
                }
            }
            employeeList.remove(findEmployee);
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public Employee updateEmployee(int id, UpdateEmployeRequest request){
        try{
            deleteEmployee(id);
            Employee updateEmployee = new Employee();

            updateEmployee.setId(id);
            updateEmployee.setFirstName(request.getFirstName());
            updateEmployee.setLastName(request.getLastName());
            updateEmployee.setDepartment(request.getDepartment());
            updateEmployee.setAge(request.getAge());

            employeeList.add(updateEmployee);

        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public List<Employee> getEmployeeWithDepartment(String department){
        List<Employee> employeeWithParams = new ArrayList<>();
        try {
            Employee findEmployee = null;
            for(Employee employee : employeeList){
                if(department.equalsIgnoreCase(employee.getDepartment())){
                    findEmployee = employee;
                    employeeWithParams.add(findEmployee);
                }
            }
            return employeeWithParams;

        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public List<Employee> findEmployeesByAge(int age){
        List<Employee> employeeWithParams = new ArrayList<>();
        try{
            for(Employee employee : employeeList){
                if(employee.getAge() >= age){
                    employeeWithParams.add(employee);
                }
            }
            return employeeWithParams;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}