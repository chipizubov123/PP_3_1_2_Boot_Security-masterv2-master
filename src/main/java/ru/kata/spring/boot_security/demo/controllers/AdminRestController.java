package ru.kata.spring.boot_security.demo.controllers;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.services.RoleService;
import ru.kata.spring.boot_security.demo.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@AllArgsConstructor
public class AdminRestController {

    private final UserService userService;

    @GetMapping()
    public ResponseEntity<List<User>> getAllUser() {
        return ResponseEntity.ok(userService.listUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity <User> getUserById (@PathVariable ("id") Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PostMapping()
    public ResponseEntity<List<User>> createUser(@RequestBody User user) {
        userService.addUser(user);
        return ResponseEntity.ok(userService.listUsers());
    }

    @PutMapping({"/{id}"})
    public ResponseEntity<List<User>> updateUser(@RequestBody User user, @PathVariable ("id") Long id){
        if (user.getPassword() == null)
            user.setPassword(userService.getUserById(user.getId()).getPassword());
        userService.updateUser(user);
        return ResponseEntity.ok(userService.listUsers());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List<User>> deleteUser(@PathVariable("id") long id) {
        userService.removeUserById(id);
        return ResponseEntity.ok(userService.listUsers());
    }

}
