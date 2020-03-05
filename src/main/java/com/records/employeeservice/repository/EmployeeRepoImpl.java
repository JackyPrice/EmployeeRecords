package com.records.employeeservice.repository;

import com.records.employeeservice.entity.EmployeeEntity;
import com.records.employeeservice.error.EmployeeNotFoundException;
import com.records.employeeservice.model.Employee;
import com.records.employeeservice.model.Role;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Repository
@ToString
public class EmployeeRepoImpl implements EmployeeRepository {

    private final MySQLRepository mySQLRepository;

    private String reformatRole(String role) {
        return Role.valueOf(role).role;
    }

    @Override
    public Employee save(Employee employee) {
        EmployeeEntity employeeEntity = EmployeeEntity.builder()
                .name(employee.getName())
                .age(employee.getAge())
                .emailAddress(employee.getEmailAddress())
                .salary(employee.getSalary())
                .role(reformatRole(employee.getRole()))
                .dateOfEnrollment(employee.getDateOfEnrollment())
                .build();
        EmployeeEntity savedEmployee = mySQLRepository.save(employeeEntity);
        return employee;
    }

    @Override
    public Employee findEmployeeById(Integer employeeId) throws EmployeeNotFoundException {
        return mySQLRepository
                .findById(employeeId)
                .map(employeeEntity -> Employee.builder()
                        .name(employeeEntity.getName())
                        .age(employeeEntity.getAge())
                        .emailAddress(employeeEntity.getEmailAddress())
                        .salary(employeeEntity.getSalary())
                        .role(employeeEntity.getRole())
                        .dateOfEnrollment(employeeEntity.getDateOfEnrollment())
                        .build())
                .orElseThrow(() -> new EmployeeNotFoundException());
    }

    @Override
    public List<Employee> findEmployeeByEmail(String employeeEmail) throws EmployeeNotFoundException {
        List<Employee> employeeList =
                mySQLRepository.findEmployeeEntityByEmailAddress(employeeEmail)
                        .stream()
                        .map(employeeEntity -> Employee.builder()
                                .name(employeeEntity.getName())
                                .age(employeeEntity.getAge())
                                .emailAddress(employeeEntity.getEmailAddress())
                                .salary(employeeEntity.getSalary())
                                .role(employeeEntity.getRole())
                                .dateOfEnrollment(employeeEntity.getDateOfEnrollment())
                                .build())
                        .collect(Collectors.toList());
        if (employeeList.isEmpty()) {
            throw new EmployeeNotFoundException();
        } else {
            return employeeList;
        }
    }
}
