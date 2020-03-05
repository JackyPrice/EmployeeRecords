package com.records.employeeservice.error;

public class EmployeeNotFoundException extends Exception{
    public EmployeeNotFoundException(){}
    public EmployeeNotFoundException(String message){
        super(message);
    }
}
