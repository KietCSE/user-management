package com.demo.learn_spring_boot.controllers;

import com.demo.learn_spring_boot.models.Users;
import com.demo.learn_spring_boot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/hi")
    public String Test() {
        return "Hello, World!, HCMUT";
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody Users user) {
        System.out.println("User registered: " + user.toString());
        userRepository.save(user);
        return ResponseEntity.status(HttpStatusCode.valueOf(200))
                .body(Map.of("message", "User registered successfully"));
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody Users user) {
        return null;
    }


}
