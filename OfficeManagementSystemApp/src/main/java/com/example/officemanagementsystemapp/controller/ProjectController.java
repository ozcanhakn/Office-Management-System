package com.example.officemanagementsystemapp.controller;

import com.example.officemanagementsystemapp.model.Project;
import com.example.officemanagementsystemapp.model.Task;
import com.example.officemanagementsystemapp.model.Employee;
import com.example.officemanagementsystemapp.service.ProjectService;
import com.example.officemanagementsystemapp.service.TaskService;
import com.example.officemanagementsystemapp.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;
    private final TaskService taskService;
    private final EmployeeService employeeService;

    @GetMapping("/projects")
    public String viewProjectPage(Model model) {
        model.addAttribute("listProjects", projectService.getAllProjects());
        return "projects";
    }

    @GetMapping("/showNewProjectForm")
    public String showNewProjectForm(Model model) {
        model.addAttribute("project", new Project());
        return "new_project";
    }

    @PostMapping("/saveProject")
    public String saveProject(@ModelAttribute("project") Project project) {
        projectService.saveProject(project);
        return "redirect:/projects";
    }

    @GetMapping("/showFormForUpdateProject/{id}")
    public String showFormForUpdateProject(@PathVariable(value = "id") long id, Model model) {
        Project project = projectService.getProjectById(id);
        model.addAttribute("project", project);
        return "update_project";
    }

    @GetMapping("/deleteProject/{id}")
    public String deleteProject(@PathVariable(value = "id") long id) {
        projectService.deleteProjectById(id);
        return "redirect:/projects";
    }

    @GetMapping("/showNewTaskForm/{projectId}")
    public String showNewTaskForm(@PathVariable(value = "projectId") long projectId, Model model) {
        model.addAttribute("task", new Task());
        model.addAttribute("employees", employeeService.getAllEmployees());
        model.addAttribute("projectId", projectId);
        return "new_task";
    }

    @PostMapping("/saveTask")
    public String saveTask(@ModelAttribute("task") Task task, @RequestParam("projectId") long projectId, @RequestParam("employeeId") long employeeId) {
        Project project = projectService.getProjectById(projectId);
        if (project == null) {
            throw new RuntimeException("Project not found for id :: " + projectId);
        }

        task.setProject(project);
        Employee employee = employeeService.getEmployeeById(employeeId);
        task.setEmployee(employee);
        taskService.saveTask(task);

        return "redirect:/projects";
    }



    @GetMapping("/assignEmployeeToProject/{projectId}/{employeeId}")
    public String assignEmployeeToProject(@PathVariable("projectId") long projectId, @PathVariable("employeeId") long employeeId) {
        Employee employee = employeeService.getEmployeeById(employeeId);
        projectService.assignEmployeeToProject(projectId, employee);
        return "redirect:/projects";
    }
}
