package com.moetez.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.moetez.demo.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername (String username);
}
