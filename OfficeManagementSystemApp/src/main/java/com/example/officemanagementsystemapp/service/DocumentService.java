package com.example.officemanagementsystemapp.service;

import com.example.officemanagementsystemapp.model.Document;

import java.util.List;

public interface DocumentService {
    List<Document> getAllDocuments();
    void saveDocument(Document document);
    Document getDocumentById(long id);
    void deleteDocumentById(long id);
}