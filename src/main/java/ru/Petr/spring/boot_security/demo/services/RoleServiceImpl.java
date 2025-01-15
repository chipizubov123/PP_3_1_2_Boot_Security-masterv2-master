package ru.Petr.spring.boot_security.demo.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.Petr.spring.boot_security.demo.DAO.RoleDAO;
import ru.Petr.spring.boot_security.demo.models.Role;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleDAO roleDAO;

    @Autowired
    public RoleServiceImpl(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }

    @Override
    public List<Role> getAllRoles() {
        return roleDAO.getAllRoles();
    }

    @Override
    public Role getRoleByUsername(String username) {
        return roleDAO.getRoleByUsername(username);
    }

    @Override
    public List<Role> getSetOfRoles(String[] roleNames) {
        return roleDAO.getSetOfRoles(roleNames);
    }

    @Override
    @Transactional
    public void add(Role role) {
        roleDAO.add(role);
    }

    @Override
    @Transactional(readOnly = true)
    public void edit(Role role) {
        roleDAO.edit(role);
    }

    @Override
    public Role getById(Long id) {
        return roleDAO.getById(id);
    }

}
