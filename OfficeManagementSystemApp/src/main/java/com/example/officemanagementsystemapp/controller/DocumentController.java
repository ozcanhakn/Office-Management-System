package com.example.officemanagementsystemapp.controller;

import com.example.officemanagementsystemapp.model.Document;
import com.example.officemanagementsystemapp.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;

@Controller
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @GetMapping("/documents")
    public String viewDocumentsPage(Model model) {
        model.addAttribute("listDocuments", documentService.getAllDocuments());
        return "documents";
    }

    @GetMapping("/showNewDocumentForm")
    public String showNewDocumentForm(Model model) {
        Document document = new Document();
        model.addAttribute("document", document);
        return "new_document";
    }

    @PostMapping("/saveDocument")
    public String saveDocument(@ModelAttribute("document") Document document,
                               @RequestParam("file") MultipartFile file) throws IOException {
        document.setUploadDate(LocalDate.now());
        document.setFileData(file.getBytes());
        documentService.saveDocument(document);
        return "redirect:/documents";
    }

    @GetMapping("/showFormForUpdateDocument/{id}")
    public String showFormForUpdateDocument(@PathVariable(value = "id") long id, Model model) {
        Document document = documentService.getDocumentById(id);
        model.addAttribute("document", document);
        return "update_document";
    }

    @GetMapping("/deleteDocument/{id}")
    public String deleteDocument(@PathVariable(value = "id") long id) {
        documentService.deleteDocumentById(id);
        return "redirect:/documents";
    }
}