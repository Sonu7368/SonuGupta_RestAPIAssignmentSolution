package com.greatlearning.employee_management.service;

import com.greatlearning.employee_management.entity.Employee;
import com.greatlearning.employee_management.entity.Role;
import com.greatlearning.employee_management.entity.User;

import java.util.List;

public interface EmployeeService {

    Role add(Role role);

    User add(User user);

    Employee add(Employee employee);

    List<Employee> getAll();

    Employee get(int id);

    void update(Employee employee);

    void delete(int id);

    List<Employee> searchByFirstName(String firstName);

    List<Employee> sortByFirstName(String order);

}
