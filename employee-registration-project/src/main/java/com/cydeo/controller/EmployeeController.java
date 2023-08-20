package com.cydeo.controller;

import com.cydeo.bootstrap.DataGenerator;
import com.cydeo.model.Employee;
import com.cydeo.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.text.DateFormat;

import static com.cydeo.bootstrap.DataGenerator.STATES;

@Controller
@AllArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/register")
    public String createEmployee(Model model){

        model.addAttribute("stateList", STATES);
        model.addAttribute("employee",new Employee());

        return "/employee/employee-create";
    }
    @PostMapping("/insert")
    public String registerConfirm(@ModelAttribute("employee") @Valid Employee employee, BindingResult bindingResult, Model model){

        if(bindingResult.hasErrors()){
            model.addAttribute("stateList", STATES);
            return "/employee/employee-create";
        }

        employeeService.saveEmployee(employee);

        return "redirect:/employee/list";
    }

    @GetMapping("/list")
    public String registerConfirm(Model model){

        model.addAttribute("employeeList",employeeService.readAllEmployees());

        return "/employee/employee-list";

    }

    @GetMapping("/login")
    public String employeeLogin(Model model){

        return "/employee/employee-login";
    }


}
