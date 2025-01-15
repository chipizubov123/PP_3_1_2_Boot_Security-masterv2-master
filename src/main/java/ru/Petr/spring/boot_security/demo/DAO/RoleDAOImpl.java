package ru.Petr.spring.boot_security.demo.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.Petr.spring.boot_security.demo.models.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RoleDAOImpl implements RoleDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public RoleDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List <Role> getAllRoles() {
        return entityManager.createQuery("select r from Role r", Role.class).getResultList();
    }

    @Override
    public Role getRoleByUsername(String name) {
        return entityManager.createQuery("Select r from Role r where r.name = :name", Role.class).setParameter("name", name).getSingleResult();
    }

    @Override
    public List<Role> getSetOfRoles(String[] roles) {
        List<Role> roleSet = new ArrayList<>();
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
