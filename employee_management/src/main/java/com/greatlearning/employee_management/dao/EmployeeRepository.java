package com.greatlearning.employee_management.dao;

import com.greatlearning.employee_management.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findByFirstNameContainsAllIgnoreCase(String firstName);

    List<Employee> findAllByOrderByFirstNameAsc();

    List<Employee> findAllByOrderByFirstNameDesc();

}
