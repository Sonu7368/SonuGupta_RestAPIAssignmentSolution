package com.greatlearning.employee_management.service;

import com.greatlearning.employee_management.dao.EmployeeRepository;
import com.greatlearning.employee_management.dao.RoleRepository;
import com.greatlearning.employee_management.dao.UserRepository;
import com.greatlearning.employee_management.entity.Employee;
import com.greatlearning.employee_management.entity.Role;
import com.greatlearning.employee_management.entity.User;
import com.greatlearning.employee_management.exception.EmployeeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder bcryptEncoder;

    @Override
    public Role add(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public User add(User user) {
        user.setPassword(bcryptEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public Employee add(Employee employee) {
        employee.setId(0);     // force a save of new item ... instead of update
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee get(int id) {
        Optional<Employee> result = employeeRepository.findById(id);
        if (result.isPresent()) return result.get();

        throw new EmployeeNotFoundException(id);
    }

    @Override
    public void update(Employee employee) {
        int id = employee.getId();
        if (employeeRepository.existsById(id)) employeeRepository.save(employee);
        else throw new EmployeeNotFoundException(id);
    }

    @Override
    public void delete(int id) {
        if (employeeRepository.existsById(id)) employeeRepository.deleteById(id);
        else throw new EmployeeNotFoundException(id);
    }

    @Override
    public List<Employee> searchByFirstName(String firstName) {
        return employeeRepository.findByFirstNameContainsAllIgnoreCase(firstName);
    }

    @Override
    public List<Employee> sortByFirstName(String order) {
        if (order.equals("desc")) return employeeRepository.findAllByOrderByFirstNameDesc();

        return employeeRepository.findAllByOrderByFirstNameAsc();
    }

}
