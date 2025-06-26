package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService service;
    //injection de dépendance
    @Autowired
    public UserController(UserService userService)
    {
        this.service = userService;
    }

    //ajouter un nouvel utilisateur
    @PostMapping
    public User addUser(@RequestBody User user)
    {
        return service.setUser(user);

    }

    @GetMapping
    public List<User> getAll()
    {
        return service.getAllUser();
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") Long id)
    {
        service.deleteUser(id);
        return "Suppression éffectué";
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") Long id)
    {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable Long id, @RequestBody User user)
    {
        service.updateUser(user);
    }

}
