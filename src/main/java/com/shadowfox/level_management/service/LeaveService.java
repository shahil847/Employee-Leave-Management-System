
package com.shadowfox.level_management.service;

import com.shadowfox.level_management.entity.LeaveRequest;
import com.shadowfox.level_management.repository.LeaveRepository;
import com.shadowfox.level_management.repository.EmployeeRepository;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class LeaveService {

    private final LeaveRepository leaveRepository;
    private final EmployeeRepository employeeRepository;

    public LeaveService(LeaveRepository leaveRepository,
                        EmployeeRepository employeeRepository) {
        this.leaveRepository = leaveRepository;
        this.employeeRepository = employeeRepository;
    }

    // Apply for leave
    public LeaveRequest applyLeave(LeaveRequest request) {

        if (!employeeRepository.existsById(request.getEmployeeId())) {
            throw new RuntimeException("Employee not found");
        }

        if (request.getStartDate() == null ||
            request.getEndDate() == null ||
            request.getStartDate().isAfter(request.getEndDate())) {
            throw new RuntimeException("Invalid leave dates");
        }

        request.setStatus("PENDING");

        return leaveRepository.save(request);
    }

    // Get all leave requests
    public List<LeaveRequest> getAllLeaves() {
        return leaveRepository.findAll();
    }

    // Get leave requests by employee
    public List<LeaveRequest> getLeavesByEmployee(Long employeeId) {
        return leaveRepository.findByEmployeeId(employeeId);
    }

    // Get pending leave requests
    public List<LeaveRequest> getPendingLeaves() {
        return leaveRepository.findByStatus("PENDING");
    }

    // Approve leave
    public LeaveRequest approveLeave(Long id) {

        LeaveRequest leave = leaveRepository.findById(id)
                .orElseThrow(() ->
                    new RuntimeException("Leave request not found"));

        if (!"PENDING".equals(leave.getStatus())) {
            throw new RuntimeException("Leave request already processed");
        }

        leave.setStatus("APPROVED");

        return leaveRepository.save(leave);
    }

    // Reject leave
    public LeaveRequest rejectLeave(Long id) {

        LeaveRequest leave = leaveRepository.findById(id)
                .orElseThrow(() ->
                    new RuntimeException("Leave request not found"));

        if (!"PENDING".equals(leave.getStatus())) {
            throw new RuntimeException("Leave request already processed");
        }

        leave.setStatus("REJECTED");

        return leaveRepository.save(leave);
    }
}
