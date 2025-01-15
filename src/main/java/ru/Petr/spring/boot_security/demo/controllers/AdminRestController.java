package ru.Petr.spring.boot_security.demo.controllers;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.Petr.spring.boot_security.demo.models.Role;
import ru.Petr.spring.boot_security.demo.models.User;
import ru.Petr.spring.boot_security.demo.services.RoleService;
import ru.Petr.spring.boot_security.demo.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@AllArgsConstructor
public class AdminRestController {

    private final UserService userService;

    private final RoleService roleService;

    @GetMapping()
    public ResponseEntity<List<User>> getAllUser() {
        return ResponseEntity.ok(userService.listUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity <User> getUserById (@PathVariable ("id") Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PostMapping()
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.addUser(user));
    }

    @PutMapping({"/{id}"})
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable ("id") Long id){
        if (user.getPassword() == null)
            user.setPassword(userService.getUserById(user.getId()).getPassword());
        return ResponseEntity.ok(userService.updateUser(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") long id) {
        userService.removeUserById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/roles")
    public ResponseEntity<List<Role>> getAllRoles() {
        List<Role> roles = roleService.getAllRoles();
        if (!roles.isEmpty()) {
            return new ResponseEntity<>(roles, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

}
