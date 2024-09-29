package com.rajibul.grscabinet.controller;


import com.rajibul.grscabinet.service.GrscabinetService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/thymeleaf/complains")

public class GrscabinetThymleafController {

    @Autowired
    private GrscabinetService grscabinetService;

    @GetMapping
    public String listGrscabinetComplain(Model model)
    {
        System.out.println("Entered into  complain url");
        model.addAttribute("complainlist", grscabinetService.getAllGrsComplain());
        model.addAttribute("sectionHeader", "Complain List");
        return "thymeleaf/complains/index";
    }

    @GetMapping("/new")
    public String createGrscabinetComplain(Model model) {

        System.out.println("Entered into add complain url");
        model.addAttribute("sectionHeader", "Add Complain");
        return "thymeleaf/complains/add";
    }




}
