package com.cydeo.controller;

import com.cydeo.model.Gender;
import com.cydeo.model.NewMentor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.cydeo.bootstrap.DataGenerator.BATCHES;
import static com.cydeo.model.Gender.FEMALE;
import static com.cydeo.model.Gender.MALE;


@Controller
@RequestMapping("/mentor")
public class NewMentorController {

    @GetMapping("/newregister")  // always be lowerCase Not("/newRegister")
    public String register(Model model){

        List<String> genderList = Arrays.asList(FEMALE.getValue(),MALE.getValue());
        model.addAttribute("gender",genderList);
        model.addAttribute("batchList",BATCHES);
        model.addAttribute("mentor",new NewMentor());

        return "mentor/newRegister";
    }

    @PostMapping("/confirm")
    public String submitForm(){

        return "mentor/confirmation";
    }

    @GetMapping("/confirm")
    public String submitForm2(){

        return "mentor/confirmation";
    }


}
