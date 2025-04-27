package com.moetez.demo.service;

import com.moetez.demo.entities.Role;
import com.moetez.demo.entities.User;
public interface UserService {
void deleteAllusers();
void deleteAllRoles();
User saveUser(User user);
User findUserByUsername (String username);
Role addRole(Role role);
User addRoleToUser(String username, String rolename);
}
