package com.example.officemanagementsystemapp.service;

import com.example.officemanagementsystemapp.model.Document;
import com.example.officemanagementsystemapp.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocumentServiceImpl implements DocumentService {

    @Autowired
    private DocumentRepository documentRepository;

    @Override
    public List<Document> getAllDocuments() {
        return documentRepository.findAll();
    }

    @Override
    public void saveDocument(Document document) {
        this.documentRepository.save(document);
    }

    @Override
    public Document getDocumentById(long id) {
        Optional<Document> optional = documentRepository.findById(id);
        Document document = null;
        if (optional.isPresent()) {
            document = optional.get();
        } else {
            throw new RuntimeException(" Document not found for id :: " + id);
        }
        return document;
    }

    @Override
    public void deleteDocumentById(long id) {
        this.documentRepository.deleteById(id);
    }
}