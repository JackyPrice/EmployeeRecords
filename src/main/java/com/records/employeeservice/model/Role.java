package com.records.employeeservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Role {
    DEVELOPER("Developer"),
    SENIOR_DEVELOPER("Senior Developer"),
    TEAM_LEAD("Team Lead"),
    TESTER("Tester"),
    BUSINESS_ANALYST("Business Analyst");

    public final String role;

    Role(String role) {
        this.role=role;
    }
}