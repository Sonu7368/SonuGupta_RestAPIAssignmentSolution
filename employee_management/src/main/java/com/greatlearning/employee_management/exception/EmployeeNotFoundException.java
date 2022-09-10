package com.greatlearning.employee_management.exception;

public class EmployeeNotFoundException extends RuntimeException {

    public EmployeeNotFoundException(int id) {
        super("Error: No Employee with id: " + id);
    }

}
