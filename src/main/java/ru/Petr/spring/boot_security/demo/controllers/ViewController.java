package ru.Petr.spring.boot_security.demo.controllers;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.Petr.spring.boot_security.demo.models.User;
import ru.Petr.spring.boot_security.demo.services.UserService;

@Controller
public class ViewController {

    @GetMapping("/")
    public String home() {

        return "redirect:/login";
    }
    public UserDetails loadUserByUsername(String username, UserService userService) throws UsernameNotFoundException {
        User user = userService.getUserByUsername(username);
        user.getAuthorities().size();
        if (user == null) {
            throw new UsernameNotFoundException(String.format("Пользователь с username = '%s' не найден", username));
        }
        return user.fromUser();
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

    @GetMapping("/user")
    public String user() {
        return "user";
    }

}
