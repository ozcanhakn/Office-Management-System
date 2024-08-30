package com.example.officemanagementsystemapp.controller;

import com.example.officemanagementsystemapp.model.Employee;
import com.example.officemanagementsystemapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // Anasayfa için gösterim
    @GetMapping("/")
    public String index() {
        // Anasayfayı döndürür
        return "index";
    }

    // Giriş yaptıktan sonra yönlendirilecek sayfa
    @GetMapping("/home_page")
    public String viewHomePage(Model model) {
        // Çalışanların listesini ekler ve home_page.html'yi döndürür
        model.addAttribute("listEmployees", employeeService.getAllEmployees());
        return "home_page";
    }

    @GetMapping("/showNewEmployeeForm")
    public String showNewEmployeeForm(Model model) {
        // Form için boş bir Employee nesnesi oluşturur
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "new_employee";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        // Çalışanı kaydeder ve ana sayfaya yönlendirir
        employeeService.saveEmployee(employee);
        return "redirect:/home_page";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
        // Güncelleme formu için çalışanı getirir
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee", employee);
        return "update_employee";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable(value = "id") long id) {
        // Çalışanı siler ve ana sayfaya yönlendirir
        this.employeeService.deleteEmployeeById(id);
        return "redirect:/home_page";
    }
}
