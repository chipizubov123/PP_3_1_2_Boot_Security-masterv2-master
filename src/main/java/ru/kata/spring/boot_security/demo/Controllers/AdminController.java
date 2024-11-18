package ru.kata.spring.boot_security.demo.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kata.spring.boot_security.demo.Models.Role;
import ru.kata.spring.boot_security.demo.Models.User;
import ru.kata.spring.boot_security.demo.Services.RoleService;
import ru.kata.spring.boot_security.demo.Services.UserService;

import java.util.Objects;
import java.util.Set;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;

    private final RoleService roleService;

    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping()
    public String homeAdminPage() {
        return "redirect:/admin/users";
    }

    @GetMapping("users")
    public String allUsers(Model model) {
        model.addAttribute("userSet", userService.listUsers());
        return "all_users";
    }

    @GetMapping(value = "users/add")
    public String newUser(@ModelAttribute("user") User user, Model model) {
        model.addAttribute("roles", roleService.getAllRoles());
        return "add_user";
    }

    @PostMapping(value = "users/add")
    public String createNewUser(@ModelAttribute("user") User user
            , @RequestParam(value = "roles") String[] roles) {
        user.setRoles(roleService.getSetOfRoles(roles));
        userService.addUser(user);
        return "redirect:/admin/users";
    }

    @GetMapping("users/{id}/edit")
    public String editUser(Model model, @PathVariable("id") Long id) {
        model.addAttribute("roles", roleService.getAllRoles());
        model.addAttribute("user", userService.getUserById(id));
        return "edit_user";
    }

    @PatchMapping("users/{id}/edit")
    public String updateUser(@ModelAttribute("user") User user) {
        var roles = user.getRoles();
        if(!roles.isEmpty()){
            user.setRoles(roles);
        }
        userService.updateUser(user);
        return "redirect:/admin/users";
    }

    @DeleteMapping("users/{id}/delete")
    public String deleteUserById(@PathVariable("id") Long id) {
        userService.removeUserById(id);
        return "redirect:/admin/users";
    }

    @GetMapping("users/{id}")
    public String show(@PathVariable("id") Long id, ModelMap modelMap) {
        modelMap.addAttribute("user", userService.getUserById(id));
        return "user_info_by_id";
    }

}
