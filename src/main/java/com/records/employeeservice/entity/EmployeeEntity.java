package com.records.employeeservice.entity;

import com.records.employeeservice.model.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity(name = "employee_records")
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String emailAddress;
    private int age;
    private LocalDate dateOfEnrollment;
    private BigDecimal salary;
    private String role;
}
