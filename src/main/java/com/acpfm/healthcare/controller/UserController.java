package com.acpfm.healthcare.controller;


import com.acpfm.healthcare.model.UnidadesAtendimento;
import com.acpfm.healthcare.model.User;
import com.acpfm.healthcare.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/User")
public class UserController {
    private static final String attributeNameUsr = "users";
    @Autowired
    private UserService userService;

    @GetMapping
    public String listUsers(Model model){
        List<User> users = userService.getAllUsers();
        model.addAttribute(attributeNameUsr,users);
        return "users";
    }

    @PostMapping("/register")
    public User registerUser(@RequestBody User user, Model model){
        userService.registerUser(user);
        //model.addAttribute(attributeNameUsr,userService.getAllUsers());
        //return "fragments/user-list :: userList";
        return user;
    }

    @PostMapping("/search")
    public String searchUsers(@RequestParam String username, Model model){
        List<User> users = userService.searchUsers(username);
        model.addAttribute(attributeNameUsr,users);
        return "fragments/user-list :: userList";
    }

    //Endpoint para atualizar registo da unidade de atendimento. É obrigatório passar o parâmetro id do registo
    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User updateUsers){
        User updateUser = userService.updateUser(id, updateUsers);
        return updateUser != null ? ResponseEntity.ok(updateUsers) : ResponseEntity.notFound().build();
    }
}
