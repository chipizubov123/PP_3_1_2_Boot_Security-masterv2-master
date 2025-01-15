package ru.Petr.spring.boot_security.demo.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.Petr.spring.boot_security.demo.models.User;
import ru.Petr.spring.boot_security.demo.services.UserService;

import java.security.Principal;

@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
public class UserRestController {

    private final UserService userService;

    @GetMapping()
    public User getAuthorisedUser(Principal principal) {
        return userService.getUserByUsername(principal.getName());
    }
}
