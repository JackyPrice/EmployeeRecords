package com.records.employeeservice.service;

import com.records.employeeservice.entity.EmployeeEntity;
import com.records.employeeservice.error.EmployeeNotFoundException;
import com.records.employeeservice.error.InvalidRoleException;
import com.records.employeeservice.model.Employee;
import com.records.employeeservice.model.Role;
import com.records.employeeservice.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
@ToString
public class EmployeeRecordService {

    private final EmployeeRepository employeeRepository;

    private boolean isValidRole(String role) throws InvalidRoleException {
        try {
            Role.valueOf(role);
            return true;
        } catch (IllegalArgumentException e) {
            throw new InvalidRoleException("INVALID ROLE: " + role + " is not a valid entry. Please select from: " + Arrays.asList(Role.values()));
        }
    }

    public void saveEmployee(Employee employee) throws InvalidRoleException {
        if (isValidRole(employee.getRole())) {
            EmployeeEntity save = employeeRepository.save(employee);
        }
    }

    public Employee findEmployeeById(Integer employeeId) throws EmployeeNotFoundException {
        return employeeRepository.findEmployeeById(employeeId);
    }

    public List<Employee> findEmployeeByEmail(String employeeEmail) throws EmployeeNotFoundException {
        return employeeRepository.findEmployeeByEmail(employeeEmail);
    }
}
