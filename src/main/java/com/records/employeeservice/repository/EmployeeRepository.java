package com.records.employeeservice.repository;

import com.records.employeeservice.error.EmployeeNotFoundException;
import com.records.employeeservice.model.Employee;

import java.util.List;

public interface EmployeeRepository {

    Employee save(Employee employee);

    Employee findEmployeeById(Integer employeeId) throws EmployeeNotFoundException;

    List<Employee> findEmployeeByEmail(String employeeEmail) throws EmployeeNotFoundException;
}
