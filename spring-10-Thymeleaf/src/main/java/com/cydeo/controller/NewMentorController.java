package com.cydeo.controller;

import com.cydeo.model.Gender;
import com.cydeo.model.Mentor;
import com.cydeo.model.NewMentor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
        return "mentor/newRegister"; // path name of the Html file
    }

    @PostMapping("/confirm")
    public String submitForm(@ModelAttribute("mentor")NewMentor mentor){
        System.out.println(mentor);

        return "redirect:/mentor/newregister"; // mapping name from another Mapping;
    }

    @GetMapping("/confirm")
    public String submitForm2(@ModelAttribute("mentor")NewMentor mentor){
        System.out.println(mentor);

        return "redirect:/mentor/newregister";
    }


}
