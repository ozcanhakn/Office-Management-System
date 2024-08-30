package com.example.officemanagementsystemapp.service;

import com.example.officemanagementsystemapp.model.Leave;

import java.util.List;

public interface LeaveService {
    List<Leave> getAllLeaves();
    void saveLeave(Leave leave);
    Leave getLeaveById(long id);
    void deleteLeaveById(long id);
}