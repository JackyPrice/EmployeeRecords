package com.records.employeeservice.service;

import com.records.employeeservice.error.EmployeeNotFoundException;
import com.records.employeeservice.model.Employee;
import com.records.employeeservice.model.Role;
import com.records.employeeservice.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@RequiredArgsConstructor
@ToString
public class EmployeeRecordService {

    private final EmployeeRepository employeeRepository;

    private boolean isValidRole(String role) {
        try {
            Role.valueOf(role);
            return true;
        }catch(IllegalArgumentException e){
            return false;
        }
    }

    public void saveEmployee(Employee employee) throws Exception {
        if (isValidRole(employee.getRole())) {
            Employee save = employeeRepository.save(employee);
        } else {
            throw new Exception("INVALID ROLE: " +  employee.getRole() + " is not a valid entry. Please select from: " + Arrays.asList(Role.values()));
        }
    }

    public Employee findEmployeeById(Integer employeeId) throws EmployeeNotFoundException {
        return employeeRepository.findEmployeeById(employeeId);
    }

    public Employee findEmployeeByEmail(String employeeEmail) {
        return employeeRepository.findEmployeeByEmail(employeeEmail);
    }
}
