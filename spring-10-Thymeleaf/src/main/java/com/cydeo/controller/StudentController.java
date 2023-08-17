package com.cydeo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import static com.cydeo.bootstrap.DataGenerator.STUDENTS;

@Controller
@RequestMapping("/student")
public class StudentController {

    @RequestMapping("/register")
    public String register(Model model){
        model.addAttribute("students", STUDENTS);
        return "student/register";
    }

    @RequestMapping("/drop")
    public String drop(){

        return "student/drop";
    }
//    @RequestMapping("/welcome")
//    public String welcome(@RequestParam Integer id, Model model){
//
//        model.addAttribute("id",id);
//        model.addAttribute("matching_student",STUDENTS.get(id));
//
//        return "student/welcome";
//    }

    @RequestMapping("/welcome")
    public String welcome(@RequestParam String name, Model model){

        model.addAttribute("studentName",name);
        return "student/welcome";
    }


}
