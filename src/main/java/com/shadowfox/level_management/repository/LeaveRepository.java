
package com.shadowfox.level_management.repository;

import com.shadowfox.level_management.entity.LeaveRequest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeaveRepository extends JpaRepository<LeaveRequest, Long> {

    // Find all leave requests of an employee
    List<LeaveRequest> findByEmployeeId(Long employeeId);

    // Find leave requests by status
    List<LeaveRequest> findByStatus(String status);
}
