package com.records.employeeservice.model;
import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
@Value
public class Employee {
    private String name;
    private String emailAddress;
    private int age;
    private LocalDate dateOfEnrollment;
    private BigDecimal salary;
    private String role;
}