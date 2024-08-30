package com.example.officemanagementsystemapp.controller;

import com.example.officemanagementsystemapp.model.Task;
import com.example.officemanagementsystemapp.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/tasks")
    public String viewTaskPage(Model model) {
        model.addAttribute("listTasks", taskService.getAllTasks());
        return "tasks";
    }

    @GetMapping("/showFormForUpdateTask/{id}")
    public String showFormForUpdateTask(@PathVariable(value = "id") long id, Model model) {
        Task task = taskService.getTaskById(id);
        model.addAttribute("task", task);
        return "update_task";
    }
    @GetMapping("/showNewTaskForm")
    public String showNewTaskForm(Model model) {
        model.addAttribute("task", new Task()); // Yeni bir boş görev oluştur
        return "new_task"; // 'new_task.html' adlı bir Thymeleaf şablonuna yönlendirir
    }


    @PostMapping("/updateTask")
    public String updateTask(@ModelAttribute("task") Task task) {
        taskService.saveTask(task);
        return "redirect:/tasks";
    }

    @GetMapping("/updateTaskStatus/{id}/{status}")
    public String updateTaskStatus(@PathVariable("id") long id, @PathVariable("status") String status) {
        taskService.updateTaskStatus(id, status);
        return "redirect:/tasks";
    }
}
