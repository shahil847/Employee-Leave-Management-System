
package com.shadowfox.level_management.controller;

import com.shadowfox.level_management.entity.LeaveRequest;
import com.shadowfox.level_management.service.LeaveService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leaves")
public class LeaveController {

    private final LeaveService leaveService;

    public LeaveController(LeaveService leaveService) {
        this.leaveService = leaveService;
    }

    // Apply for leave
    @PostMapping
    public LeaveRequest applyLeave(@RequestBody LeaveRequest request) {
        return leaveService.applyLeave(request);
    }

    // Get all leave requests
    @GetMapping
    public List<LeaveRequest> getAllLeaves() {
        return leaveService.getAllLeaves();
    }

    // Get leaves by employee ID
    @GetMapping("/employee/{employeeId}")
    public List<LeaveRequest> getLeavesByEmployee(
            @PathVariable Long employeeId) {
        return leaveService.getLeavesByEmployee(employeeId);
    }

    // Get pending leaves
    @GetMapping("/pending")
    public List<LeaveRequest> getPendingLeaves() {
        return leaveService.getPendingLeaves();
    }

    // Approve leave
    @PutMapping("/{id}/approve")
    public LeaveRequest approveLeave(@PathVariable Long id) {
        return leaveService.approveLeave(id);
    }

    // Reject leave
    @PutMapping("/{id}/reject")
    public LeaveRequest rejectLeave(@PathVariable Long id) {
        return leaveService.rejectLeave(id);
    }
}
