package com.greatlearning.employee_management.controller;

import com.greatlearning.employee_management.entity.Employee;
import com.greatlearning.employee_management.entity.Role;
import com.greatlearning.employee_management.entity.User;
import com.greatlearning.employee_management.exception.EmployeeNotFoundException;
import com.greatlearning.employee_management.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/user")
    public User add(@RequestBody User user) {
        return employeeService.add(user);
    }

    @PostMapping("/role")
    public Role add(@RequestBody Role role) {
        return employeeService.add(role);
    }

    @PostMapping("/employees")
    public Employee add(@RequestBody Employee employee) {
        return employeeService.add(employee);
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAll();
    }

    @PutMapping("/employees")
    public ResponseEntity<?> updateEmployee(@RequestBody Employee employee) {
        try {
            employeeService.update(employee);
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } catch (EmployeeNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<?> getEmployee(@PathVariable int id) {
        try {
            Employee employee = employeeService.get(id);
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } catch (EmployeeNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable int id) {
        try {
            employeeService.delete(id);
            return new ResponseEntity<>("Deleted employee id - " + id, HttpStatus.OK);
        } catch (EmployeeNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/employees/search/{firstName}")
    public List<Employee> searchByFirstName(@PathVariable String firstName) {
        return employeeService.searchByFirstName(firstName);
    }

    @GetMapping("/employees/sort")
    public List<Employee> sortByFirstName(@RequestParam(name = "order") String order) {
        return employeeService.sortByFirstName(order);
    }

}
