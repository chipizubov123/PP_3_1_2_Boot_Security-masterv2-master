package ru.kata.spring.boot_security.demo.Controllers;



import org.springframework.beans.factory.annotation.Autowired;
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
import ru.kata.spring.boot_security.demo.Models.User;
import ru.kata.spring.boot_security.demo.Services.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminRestController {

//    private final UserService userService;
//
//    public AdminRestController(UserService userService) {
//        this.userService = userService;
//    }
//
//    @GetMapping()
//    public ResponseEntity<List<User>> getAll() {
//        final List<User> allUsers = userService.listUsers();
//        return allUsers != null && !allUsers.isEmpty()
//                ? new ResponseEntity<>(allUsers, HttpStatus.OK)
//                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity <User> getUserById (@PathVariable("id") Long id) {
//        return ResponseEntity.ok(userService.getUserById(id));
//    }
//
//    @PostMapping
//    public ResponseEntity<User> addUser (@RequestBody User user) {
//
//        return ResponseEntity.ok(userService.addUser(user));
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<User> editUser (@RequestBody User user, @PathVariable ("id") Long id) {
//        return ResponseEntity.ok(userService.updateUser(user));
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteUser (@PathVariable ("id") Long id) {
//
//        userService.removeUserById(id);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

    private final UserService userService;

    @Autowired
    public AdminRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public ResponseEntity<List<User>> getAllUser() {
        return ResponseEntity.ok(userService.listUsers());
    }

    @PostMapping()
    public ResponseEntity<List<User>> createUser(@RequestBody User user) {
        userService.addUser(user);
        return ResponseEntity.ok(userService.listUsers());
    }

    @PutMapping()
    public ResponseEntity<List<User>> updateUser(@RequestBody User user) {
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
