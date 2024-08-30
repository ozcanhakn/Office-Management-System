package com.example.officemanagementsystemapp.service;

import com.example.officemanagementsystemapp.model.Information;

import java.util.List;

public interface InformationService {
    List<Information> getAllInformation();
    void saveInformation(Information information);
    Information getInformationById(long id);
    void deleteInformationById(long id);
}