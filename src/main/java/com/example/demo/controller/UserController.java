package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    UserService service;
    //injection de dépendance
    public UserController(UserService userService)
    {
        this.service = userService;
    }

    //ajouter un nouvel utilisateur
    @PostMapping("/user")
    public void addUser(@RequestBody User user)
    {
        service.setUser(user);
    }

    @GetMapping("/users")
    public List<User> getAll()
    {
        return service.getAllUser();
    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable Long id)
    {
        service.deleteUser(id);
        return "Suppression éffectué";
    }

    @GetMapping("/users/{nom}")
    public User getUser(@PathVariable String nom)
    {
        return service.getByNom(nom);
    }

    @PutMapping("/user")
    public void updateUser(@RequestBody User user)
    {
        service.setUser(user);
    }

}
