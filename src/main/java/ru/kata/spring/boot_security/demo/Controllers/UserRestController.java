package ru.kata.spring.boot_security.demo.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kata.spring.boot_security.demo.Models.User;
import ru.kata.spring.boot_security.demo.Services.UserService;

import java.security.Principal;



//@RestController
//@RequestMapping("/api/user")
//
//public class UserRestController {
//
//
//    public UserRestController(UserService userService) {
//        this.userService = userService;
//    }
//
//    private final UserService userService;
//
//    @GetMapping
//    public User getAuthorisedUser (Principal principal) {
//        return userService.getUserByUsername(principal.getName());
//    }
//}
