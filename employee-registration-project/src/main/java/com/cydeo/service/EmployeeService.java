package com.cydeo.service;

import com.cydeo.model.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeService {

    public static List<Employee> employeeList = new ArrayList<>();

    public void saveEmployee(Employee employee){
        employeeList.add(employee);
    }

    public List<Employee> readAllEmployees(){
        return employeeList;
    }

    public boolean isRegistered(String email){
        for (Employee employee : employeeList) {
            if (employee.getEmail().equals(email)) return true;
        }return false;
    }

    public boolean isPasswordMatch(String password){
        for (Employee employee : employeeList) {
            if (employee.getPassword().equals(password)) return true;
        }return false;
    }
}
