package com.example.officemanagementsystemapp.service;

import com.example.officemanagementsystemapp.model.Task;
import com.example.officemanagementsystemapp.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public void saveTask(Task task) {
        taskRepository.save(task);
    }

    @Override
    public Task getTaskById(long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found for id :: " + id));
    }

    @Override
    public void deleteTaskById(long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public void updateTaskStatus(long id, String status) {
        Task task = getTaskById(id);
        task.setStatus(status);
        saveTask(task);
    }


}
