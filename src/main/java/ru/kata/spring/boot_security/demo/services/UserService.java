package ru.kata.spring.boot_security.demo.services;


import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.models.User;

import java.util.List;

public interface UserService {

    User getUserByUsername(String username);

    void addUser(User user);

    void addUser(User user, List<Role> roles);

    User getUserById(Long id);

    void updateUser(User user);

    void removeUserById(Long id);

    List<User> listUsers();

}
