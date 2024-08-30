package com.example.officemanagementsystemapp.controller;

import com.example.officemanagementsystemapp.model.Information;
import com.example.officemanagementsystemapp.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class InformationController {

    @Autowired
    private InformationService informationService;

    @GetMapping("/information")
    public String viewInformationPage(Model model) {
        model.addAttribute("listInformation", informationService.getAllInformation());
        return "information";
    }

    @GetMapping("/showNewInformationForm")
    public String showNewInformationForm(Model model) {
        Information information = new Information();
        model.addAttribute("information", information);
        return "new_information";
    }

    @PostMapping("/saveInformation")
    public String saveInformation(@ModelAttribute("information") Information information) {
        informationService.saveInformation(information);
        return "redirect:/information";
    }

    @GetMapping("/showFormForUpdateInformation/{id}")
    public String showFormForUpdateInformation(@PathVariable(value = "id") long id, Model model) {
        Information information = informationService.getInformationById(id);
        model.addAttribute("information", information);
        return "update_information";
    }

    @GetMapping("/deleteInformation/{id}")
    public String deleteInformation(@PathVariable(value = "id") long id) {
        informationService.deleteInformationById(id);
        return "redirect:/information";
    }
}