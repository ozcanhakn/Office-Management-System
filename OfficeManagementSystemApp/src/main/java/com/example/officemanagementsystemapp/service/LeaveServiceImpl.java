package com.example.officemanagementsystemapp.service;

import com.example.officemanagementsystemapp.model.Leave;
import com.example.officemanagementsystemapp.repository.LeaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LeaveServiceImpl implements LeaveService {

    @Autowired
    private LeaveRepository leaveRepository;

    @Override
    public List<Leave> getAllLeaves() {
        return leaveRepository.findAll();
    }

    @Override
    public void saveLeave(Leave leave) {
        leaveRepository.save(leave);
    }

    @Override
    public Leave getLeaveById(long id) {
        Optional<Leave> optional = leaveRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new RuntimeException("Leave not found for id :: " + id);
        }
    }

    @Override
    public void deleteLeaveById(long id) {
        leaveRepository.deleteById(id);
    }
}