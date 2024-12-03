package ru.kata.spring.boot_security.demo.Services;

import ru.kata.spring.boot_security.demo.Models.Role;

import java.util.List;

public interface RoleService {

    List<Role> getAllRoles();

    Role getRoleByUsername(String username);

    List<Role> getSetOfRoles(String[] roleNames);

    void add(Role role);

    void edit(Role role);

    Role getById(Long id);
}
