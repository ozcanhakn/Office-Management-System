package com.example.officemanagementsystemapp.repository;

import com.example.officemanagementsystemapp.model.Information;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InformationRepository extends JpaRepository<Information, Long> {
}