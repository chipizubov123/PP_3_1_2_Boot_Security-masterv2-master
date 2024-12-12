package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kata.spring.boot_security.demo.services.UserServiceImpl;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {
//    private UserService userService;
//
//    @Autowired
//    public void setUserService(UserService userService) {
//
//        this.userService = userService;
//    }
//
//    @GetMapping
//    public String userInfo(@AuthenticationPrincipal User user, Model model) {
//        model.addAttribute("roles", userService.getUserByUsername(user.getUsername()).getRoles());
//        model.addAttribute("user", userService.getUserByUsername(user.getUsername()));
//        return "user";
//    }
private final UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String showPageUser(Principal principal, Model model) {
        model.addAttribute("user", userService.getUserByUsername(principal.getName()));
        return "user";
    }
}
