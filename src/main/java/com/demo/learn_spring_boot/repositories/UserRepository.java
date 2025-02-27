package com.demo.learn_spring_boot.repositories;

import com.demo.learn_spring_boot.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Integer> {
    public Users findByName(String name);
}
