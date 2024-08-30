package com.example.officemanagementsystemapp.controller;

import com.example.officemanagementsystemapp.model.Leave;
import com.example.officemanagementsystemapp.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LeaveController {

    @Autowired
    private LeaveService leaveService;

    // Display list of leaves
    @GetMapping("/leaves")
    public String viewLeavePage(Model model) {
        model.addAttribute("listLeaves", leaveService.getAllLeaves());
        return "leave_list";
    }

    @GetMapping("/showNewLeaveForm")
    public String showNewLeaveForm(Model model) {
        Leave leave = new Leave();
        model.addAttribute("leave", leave);
        return "new_leave";
    }

    @PostMapping("/saveLeave")
    public String saveLeave(@ModelAttribute("leave") Leave leave) {
        leaveService.saveLeave(leave);
        return "redirect:/leaves";
    }

    @GetMapping("/showFormForUpdateLeave/{id}")
    public String showFormForUpdateLeave(@PathVariable(value = "id") long id, Model model) {
        Leave leave = leaveService.getLeaveById(id);
        model.addAttribute("leave", leave);
        return "update_leave";
    }

    @GetMapping("/deleteLeave/{id}")
    public String deleteLeave(@PathVariable(value = "id") long id) {
        leaveService.deleteLeaveById(id);
        return "redirect:/leaves";
    }
}