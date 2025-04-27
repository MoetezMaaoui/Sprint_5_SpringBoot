package com.moetez.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.moetez.demo.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	Role findByRole(String role);
}