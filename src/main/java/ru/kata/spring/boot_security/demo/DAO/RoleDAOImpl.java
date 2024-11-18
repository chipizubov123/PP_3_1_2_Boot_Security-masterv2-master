package ru.kata.spring.boot_security.demo.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.Models.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashSet;
import java.util.Set;

@Repository
public class RoleDAOImpl implements RoleDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public RoleDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Set<Role> getAllRoles() {
        return new HashSet<>(entityManager.createQuery("from Role", Role.class).getResultList());
    }

    @Override
    public Role getRoleByUsername(String name) {
        return entityManager.createQuery("from Role where name = :name", Role.class).setParameter("name", name).getSingleResult();
    }

    @Override
    public Set<Role> getSetOfRoles(String[] roles) {
        Set<Role> roleSet = new HashSet<>();
        for (String role : roles) {
            roleSet.add(getRoleByUsername(role));
        }
        return roleSet;
    }

    @Override
    public void add(Role role) {
        entityManager.persist(role);
    }

    @Override
    public void edit(Role role) {
        entityManager.merge(role);
    }

    @Override
    public Role getById(Long id) {
        return entityManager.find(Role.class, id);
    }
}
