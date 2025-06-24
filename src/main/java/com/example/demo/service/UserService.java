package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repositorie.UserRepositorie;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    //injection de dépendance
    UserRepositorie userRepositorie;
    public UserService(UserRepositorie userRepositorie1)
    {
        this.userRepositorie = userRepositorie1;
    }

    //service insertion et mise à jour
    public void setUser(User user)
    {
        //verifier que les champs ne sont pas vide
        if((!user.getPrenom().isEmpty())&&(!user.getNom().isEmpty()))
        {
            //inserer l'objet dans la base de données
            userRepositorie.save(user);
            System.out.println("Ajout éffectué");
        }
    }

    //retourner la liste des users
    public List<User> getAllUser()
    {
        return userRepositorie.findAll();
    }

    //retourner un user grace à son Id
    public User getByNom(String nom)
    {
        return userRepositorie.findByNom(nom);
    }

    //effacer un user grace à son Id
    public void deleteUser(Long id)
    {
        userRepositorie.deleteById(id);
    }




}
