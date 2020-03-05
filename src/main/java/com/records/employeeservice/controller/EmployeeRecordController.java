package com.records.employeeservice.controller;

import com.records.employeeservice.error.EmployeeNotFoundException;
import com.records.employeeservice.model.Employee;
import com.records.employeeservice.service.EmployeeRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EmployeeRecordController {

    private final EmployeeRecordService employeeRecordService;

    @PostMapping(value = "/employee")
    public void addEmployee(@RequestBody Employee employee) throws Exception {
        employeeRecordService.saveEmployee(employee);
    }

    @GetMapping("/getEmployee/{employeeId}")
    public Employee getEmployeeById(@PathVariable("employeeId") Integer employeeId){
        try {
            return employeeRecordService.findEmployeeById(employeeId);
        } catch (EmployeeNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error: Employee ID " + employeeId + " was not found", e);
        }
    }

    @GetMapping("/getEmployee")
    public List<Employee> getEmployeeByEmail(@RequestHeader("employeeEmail") String employeeEmail){
        try {
        return employeeRecordService.findEmployeeByEmail(employeeEmail);
        } catch (EmployeeNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error: Employee Email " + employeeEmail + " was not found", e);
        }
    }
}
