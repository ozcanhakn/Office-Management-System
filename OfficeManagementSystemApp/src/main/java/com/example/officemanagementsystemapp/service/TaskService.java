package com.example.officemanagementsystemapp.service;

import com.example.officemanagementsystemapp.model.Task;

import java.util.List;


public interface TaskService {
    List<Task> getAllTasks();
    void saveTask(Task task);
    Task getTaskById(long id);
    void deleteTaskById(long id);
    void updateTaskStatus(long id, String status);

}
