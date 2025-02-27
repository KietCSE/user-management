package com.demo.learn_spring_boot.controllers;

import com.demo.learn_spring_boot.models.Balance;
import com.demo.learn_spring_boot.models.Users;
import com.demo.learn_spring_boot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/add")
    public ResponseEntity<?> addUser(@RequestBody Users user) {
        Users createdUser = userRepository.findByName(user.getName());
        if (createdUser != null) ResponseEntity.ok("User has alreadly added");

        Balance newbalance = new Balance();
        newbalance.setMoney(1000);
        newbalance.setUser(user);
        user.setBalance(newbalance);
        userRepository.save(user);

        return ResponseEntity.ok("User added successfully");
    }

    @GetMapping("/hi")
    public String hi() { return "kaka"; }

    @GetMapping("/get")
    public ResponseEntity<?> getUser(@RequestParam String name) {
        Users user = userRepository.findByName(name);
        if (user == null) {
            return ResponseEntity.ok("User not found");
        }

        int money = user.getBalance().getMoney();

        return ResponseEntity.ok(Map.of("money", money, "id",user.getId(), "name", user.getName()));
    }
}
