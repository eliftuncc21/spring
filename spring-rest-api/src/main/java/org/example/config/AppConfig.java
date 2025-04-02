package org.example.config;

import org.example.model.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class AppConfig {

    @Bean
    public List<Employee> employeeList(){
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(1,"Zeynep","Gümüş","IT", 45));
        employeeList.add(new Employee(2,"Ece","Yazıcı", "HR", 24));
        employeeList.add(new Employee(3,"Melih","Turan", "Finance", 27));
        employeeList.add(new Employee(4,"Atakan","Yılmaz", "Marketing", 37));

        return employeeList;
    }
}
