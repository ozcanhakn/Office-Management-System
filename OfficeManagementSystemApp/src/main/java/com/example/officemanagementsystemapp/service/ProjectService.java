package com.example.officemanagementsystemapp.service;

import com.example.officemanagementsystemapp.model.Project;
import com.example.officemanagementsystemapp.model.Task;
import com.example.officemanagementsystemapp.model.Employee;
import com.example.officemanagementsystemapp.repository.ProjectRepository;
import com.example.officemanagementsystemapp.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

public interface ProjectService {
    List<Project> getAllProjects();
    void saveProject(Project project);
    Project getProjectById(long id);
    void deleteProjectById(long id);
    void addTaskToProject(long projectId, Task task);
    void removeTaskFromProject(long projectId, long taskId);
    void assignEmployeeToProject(long projectId, Employee employee);


}