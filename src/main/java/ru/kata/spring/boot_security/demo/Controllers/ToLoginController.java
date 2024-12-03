package ru.kata.spring.boot_security.demo.Controllers;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.kata.spring.boot_security.demo.DAO.UserDAO;
import ru.kata.spring.boot_security.demo.Models.User;

//@Controller
//public class ToLoginController {
//    @GetMapping("/")
//    public String home() {
//
//        return "redirect:/login";
//    }
//    public UserDetails loadUserByUsername(String username, UserDAO userDAO) throws UsernameNotFoundException {
//        User user = userDAO.getUserByUsername(username);
//        user.getAuthorities().size();
//        if (user == null) {
//            throw new UsernameNotFoundException(String.format("Пользователь с username = '%s' не найден", username));
//        }
//        return user.fromUser();
//    }
//
//}
