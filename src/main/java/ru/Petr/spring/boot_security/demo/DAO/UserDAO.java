package ru.Petr.spring.boot_security.demo.DAO;

import ru.Petr.spring.boot_security.demo.models.User;

import java.util.List;

public interface UserDAO {
    User getUserByUsername(String username);

    User addUser(User user);

    User getUserById(Long id);

    User updateUser(User user);

    void removeUserById(Long id);

    List<User> listUsers();
}
