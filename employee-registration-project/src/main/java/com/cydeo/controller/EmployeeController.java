package com.cydeo.controller;

import com.cydeo.model.Employee;
import com.cydeo.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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

        return "employee/employee-list";

    }

    @PostMapping("/login/confirm")
    public String employeeLoginConfirm(
            @ModelAttribute("email") String email,
            String password,
            @RequestParam(required = false, defaultValue = "false") boolean remember_me,
            Model model) {

        if(email.isEmpty()){
            model.addAttribute("error", "Enter your email");
        }
        else if (employeeService.isRegistered(email)) {
            if (employeeService.isPasswordMatch(password)) {
                return "redirect:/employee/list";
            } else {
                model.addAttribute("error", "Invalid email or password");
            }
        } else {
            model.addAttribute("error", "You are not registered yet");
        }

        return "employee/employee-login"; // Redirect back to the login page
    }


}
