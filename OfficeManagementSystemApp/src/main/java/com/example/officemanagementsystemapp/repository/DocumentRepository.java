package com.example.officemanagementsystemapp.repository;

import com.example.officemanagementsystemapp.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document, Long> {
}
