package com.records.employeeservice.repository;

import com.records.employeeservice.entity.EmployeeEntity;
import com.records.employeeservice.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MySQLRepository extends JpaRepository<EmployeeEntity, Integer> {
    List<EmployeeEntity> findEmployeeEntityByEmailAddress(String emailAddress);
    Employee findEmployeeEntityByEmailAddressAndName(String emailAddress, String name);
}
