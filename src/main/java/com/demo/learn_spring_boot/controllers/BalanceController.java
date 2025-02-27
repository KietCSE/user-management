package com.demo.learn_spring_boot.controllers;

import com.demo.learn_spring_boot.models.Balance;
import com.demo.learn_spring_boot.models.Users;
import com.demo.learn_spring_boot.repositories.BalanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("balance")
public class BalanceController {
    @Autowired
    private BalanceRepository balanceRepository;


//    this try to access One-to-One in bidirectional relationship
    @GetMapping("/get")
    public ResponseEntity<?> getBalance(@RequestParam Integer id) {
        Optional<Balance> balanceEntity = balanceRepository.findById(id);
        if (balanceEntity.isPresent()) {
            Users user = balanceEntity.get().getUser();
            return ResponseEntity.ok(Map.of("name", user.getName(), "money", balanceEntity.get().getMoney()));
        }
        return ResponseEntity.ok("Balance not found");
    }
}
