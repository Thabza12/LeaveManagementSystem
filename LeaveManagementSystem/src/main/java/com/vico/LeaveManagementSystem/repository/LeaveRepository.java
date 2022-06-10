package com.vico.LeaveManagementSystem.repository;

import com.vico.LeaveManagementSystem.domain.Leave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaveRepository extends JpaRepository<Leave, Integer> {

}
