package com.cydeo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static com.cydeo.bootstrap.DataGenerator.MENTORS;

@Controller
@RequestMapping("/mentor")
public class MentorController {
    @RequestMapping("/register")
    public String register(Model model){
        model.addAttribute("mentors", MENTORS);
        return "mentor/register";
    }

    @RequestMapping("/drop")
    public String drop(){

        return "mentor/drop";
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

        model.addAttribute("mentorName",name);
        return "mentor/welcome";
    }

}
