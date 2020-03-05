package com.records.employeeservice.repository;

import com.records.employeeservice.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MySQLRepository extends JpaRepository<EmployeeEntity, Integer> {
}
