package com.greatlearning.employee_management.dao;

import com.greatlearning.employee_management.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
