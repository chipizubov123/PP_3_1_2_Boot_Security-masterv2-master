package ru.kata.spring.boot_security.demo.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.services.RoleService;
import ru.kata.spring.boot_security.demo.services.UserService;

//@Controller
//@RequestMapping("/admin")
//public class AdminController {
//
//    private final UserService userService;
//
//    private final RoleService roleService;
//
//    @Autowired
//    public AdminController(UserService userService, RoleService roleService) {
//        this.userService = userService;
//        this.roleService = roleService;
//    }
//
//    @GetMapping()
//    public String getAllUser(@AuthenticationPrincipal UserDetails userDetails, Model model) {
//        String username = userDetails.getUsername();
//        model.addAttribute("users", userService.listUsers());
//        model.addAttribute("user", userService.getUserByUsername(username));
//        model.addAttribute("roles", roleService.getAllRoles());
//        return "admin";
//    }
//
//    @PostMapping("/new")
//    public String createUser(@ModelAttribute("user") User user,
//                             @RequestParam(value = "nameRoles", required = false) String[] roles) {
//        user.setRoles(roleService.getSetOfRoles(roles));
//        userService.addUser(user);
//        return "redirect:/admin";
//    }
//
//    @PostMapping("/update/{id}")
//    public String update(@ModelAttribute("users") User user,
//                         @RequestParam(value = "roleName", required = false) String[] roles) {
//        user.setRoles(roleService.getSetOfRoles(roles));
//        userService.updateUser(user);
//        return "redirect:/admin";
//    }
//
//    @PostMapping("/delete/{id}")
//    public String deleteUser(@PathVariable("id") long id) {
//        userService.removeUserById(id);
//        return "redirect:/admin";
//    }
//
//}
