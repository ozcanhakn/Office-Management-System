package com.example.officemanagementsystemapp.service;

import com.example.officemanagementsystemapp.model.Project;
import com.example.officemanagementsystemapp.model.Task;
import com.example.officemanagementsystemapp.model.Employee;
import com.example.officemanagementsystemapp.repository.ProjectRepository;
import com.example.officemanagementsystemapp.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final TaskRepository taskRepository;

    @Override
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public void saveProject(Project project) {
        projectRepository.save(project);
    }

    @Override
    public Project getProjectById(long id) {
        return projectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Project not found for id :: " + id));
    }

    @Override
    public void deleteProjectById(long id) {
        projectRepository.deleteById(id);
    }

    @Override
    public void addTaskToProject(long projectId, Task task) {
        Project project = getProjectById(projectId);
        task.setProject(project);
        taskRepository.save(task);
    }

    @Override
    public void removeTaskFromProject(long projectId, long taskId) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found for id :: " + taskId));
        if (task.getProject().getId() == projectId) {
            task.setProject(null);
            taskRepository.save(task);
        }
    }

    @Override
    public void assignEmployeeToProject(long projectId, Employee employee) {
        Project project = getProjectById(projectId);
        project.getEmployees().add(employee);
        projectRepository.save(project);
    }


}
