package com.vitima.vitima.controller;
import com.vitima.vitima.models.User;
import com.vitima.vitima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
// @CrossOrigin(origins = "http://")
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<User> getUsuario(@PathVariable Long id) {
        User usuario = userService.findById(id);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> usuarios = userService.findAllUsers();
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }
    @GetMapping("/passwords")
    public ResponseEntity<List<String>> getAllPasswordsa() {
        List<String> passwords = userService.findAllPasswords();
        return new ResponseEntity<>(passwords, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user) {
        System.out.println("Criando user");
        User createUser = userService.createUser(user);
        return new ResponseEntity<>(createUser, HttpStatus.CREATED);
    }

}
