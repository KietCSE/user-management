package com.demo.learn_spring_boot.repositories;

import com.demo.learn_spring_boot.models.Balance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BalanceRepository extends JpaRepository<Balance, Integer> {
    public Optional<Balance> findById (Integer Id);
}
