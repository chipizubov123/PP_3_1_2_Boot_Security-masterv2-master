package ru.kata.spring.boot_security.demo.DAO;

import ru.kata.spring.boot_security.demo.Models.Role;

import java.util.List;
import java.util.Set;

public interface RoleDAO {
    List <Role> getAllRoles();

    Role getRoleByUsername(String username);

    List<Role> getSetOfRoles(String[] roles);

    void add(Role role);

    void edit(Role role);

    Role getById(Long id);
}
