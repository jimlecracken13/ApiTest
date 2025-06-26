package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repositorie.UserRepositorie;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    //injection de dépendance
    UserRepositorie userRepositorie;
    public UserService(UserRepositorie userRepositorie1)
    {
        this.userRepositorie = userRepositorie1;
    }

    //service insertion
    public User setUser(User user)
    {
        return userRepositorie.save(user);
    }

    //retourner la liste des users
    public List<User> getAllUser()
    {
        return userRepositorie.findAll();
    }

    //retourner un user grace à son Id
    public User getById(Long id)
    {
        Optional<User> user = userRepositorie.findById(id);
        return user.orElse(null);
    }

    //effacer un user grace à son Id
    public void deleteUser(Long id)
    {
        userRepositorie.deleteById(id);
    }

    //modifier un user
    public void updateUser(User user)
    {
        //je recupère le user
        Optional<User> userOptional = userRepositorie.findById(user.getId());
        if(userOptional.isPresent())
        {
            userOptional.get().setNom(user.getNom());
            userOptional.get().setPrenom(user.getPrenom());
            userRepositorie.save(userOptional.get());
        }

    }


}
