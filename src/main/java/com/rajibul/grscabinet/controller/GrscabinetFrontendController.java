package com.rajibul.grscabinet.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/complains")
public class GrscabinetFrontendController {

    @GetMapping
    public String listGrscabinetComplain()
    {
        return "complains";
    }

    @GetMapping("/new")
    public String createGrscabinetComplain() {
        return "add";
    }

    @GetMapping("/edit/{id}")
    public String editGrscabinetComplain(@PathVariable String id) {
        return "edit";
    }
}
