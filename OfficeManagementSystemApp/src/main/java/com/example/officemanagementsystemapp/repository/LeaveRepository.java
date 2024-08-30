package com.example.officemanagementsystemapp.repository;

import com.example.officemanagementsystemapp.model.Leave;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaveRepository extends JpaRepository<Leave, Long> {
}