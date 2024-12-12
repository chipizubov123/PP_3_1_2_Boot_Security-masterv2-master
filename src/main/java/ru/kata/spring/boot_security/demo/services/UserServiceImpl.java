package ru.kata.spring.boot_security.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.DAO.UserDAO;
import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.models.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserDAO userDAO;

    private final BCryptPasswordEncoder bCryptPasswordEncode;

    @Autowired
    public UserServiceImpl(UserDAO userDAO, BCryptPasswordEncoder bCryptPasswordEncode) {
        this.userDAO = userDAO;
        this.bCryptPasswordEncode = bCryptPasswordEncode;
    }


    @Transactional(readOnly = true)
    public User getUserByUsername(String username) {
        return userDAO.getUserByUsername(username);
    }

    @Transactional
    public void addUser(User user) {
        user.setPassword(bCryptPasswordEncode.encode(user.getPassword()));
        userDAO.addUser(user);
    }

    @Transactional
    public void addUser(User user, List <Role> roles) {
        user.setRoles(roles);
        user.setPassword(bCryptPasswordEncode.encode(user.getPassword()));
        userDAO.addUser(user);
    }

    @Transactional(readOnly = true)
    public User getUserById(Long id) {
        return userDAO.getUserById(id);
    }

    @Override
    @Transactional()
    public void updateUser(User user) {

        if (user.getRoles().isEmpty()) {
            var roles = userDAO.getUserById(user.getId()).getRoles();
            user.setRoles(roles);
        }
        userDAO.updateUser(user);
    }

    @Override
    @Transactional()
    public void removeUserById(Long id) {
        userDAO.removeUserById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> listUsers() {
        return userDAO.listUsers();
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userDAO.getUserByUsername(username);
    }
}
