package com.example.officemanagementsystemapp.repository;

import com.example.officemanagementsystemapp.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
