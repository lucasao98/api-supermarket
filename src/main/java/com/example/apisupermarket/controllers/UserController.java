package com.example.apisupermarket.controllers;

import com.example.apisupermarket.domain.user.RequestUser;
import com.example.apisupermarket.domain.user.User;
import com.example.apisupermarket.domain.user.UserRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity updateUser(@PathVariable Integer id, @RequestBody @Valid RequestUser data){
        Optional<User> optionalUser = repository.findById(id);

        if(optionalUser.isPresent()) {
            User user = optionalUser.get();

            user.setUser_cpf(data.user_cpf());
            user.setUser_email(data.user_email());
            user.setUser_password(data.user_password());
            user.setUser_phone(data.user_phone());

            repository.save(user);

            return ResponseEntity.ok(user);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id){
        Optional<User> optionalUser = repository.findById(id);

        if(optionalUser.isPresent()){
            repository.deleteById(id);

            return ResponseEntity.ok("Usuário Removido com Sucesso!c");
        }else{
            return ResponseEntity.notFound().build();
        }

    }
}
