package com.records.employeeservice.repository;

import com.records.employeeservice.error.EmployeeNotFoundException;
import com.records.employeeservice.model.Employee;

public interface EmployeeRepository {

    Employee save(Employee employee);

    Employee findEmployeeById(Integer employeeId) throws EmployeeNotFoundException;

    Employee findEmployeeByEmail(String employeeEmail);
}
