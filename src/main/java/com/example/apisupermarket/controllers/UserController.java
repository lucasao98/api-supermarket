package com.example.apisupermarket.controllers;

import com.example.apisupermarket.domain.user.RequestUser;
import com.example.apisupermarket.domain.user.User;
import com.example.apisupermarket.domain.user.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository repository;
    @GetMapping()
    public ResponseEntity getUsers(){
        var users = repository.findAll();

        return ResponseEntity.ok(users);
    }
    @PostMapping("")
    public ResponseEntity store(@RequestBody @Valid RequestUser data){
        User newUser = new User(data);
        repository.save(newUser);

        return ResponseEntity.ok().build();
    }
}
