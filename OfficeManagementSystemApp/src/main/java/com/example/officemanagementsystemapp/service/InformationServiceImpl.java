package com.example.officemanagementsystemapp.service;

import com.example.officemanagementsystemapp.model.Information;
import com.example.officemanagementsystemapp.repository.InformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InformationServiceImpl implements InformationService {

    @Autowired
    private InformationRepository informationRepository;

    @Override
    public List<Information> getAllInformation() {
        return informationRepository.findAll();
    }

    @Override
    public void saveInformation(Information information) {
        this.informationRepository.save(information);
    }

    @Override
    public Information getInformationById(long id) {
        Optional<Information> optional = informationRepository.findById(id);
        Information information = null;
        if (optional.isPresent()) {
            information = optional.get();
        } else {
            throw new RuntimeException(" Information not found for id :: " + id);
        }
        return information;
    }

    @Override
    public void deleteInformationById(long id) {
        this.informationRepository.deleteById(id);
    }
}