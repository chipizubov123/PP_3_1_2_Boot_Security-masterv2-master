package ru.kata.spring.boot_security.demo.DAO;

import ru.kata.spring.boot_security.demo.models.Role;

import java.util.List;

public interface RoleDAO {
    List <Role> getAllRoles();

    Role getRoleByUsername(String username);

    List<Role> getSetOfRoles(String[] roles);

    void add(Role role);

    void edit(Role role);

    Role getById(Long id);
}
