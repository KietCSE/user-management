package com.demo.learn_spring_boot.dto;

import lombok.Data;

@Data
public class RegisterUser {
    private String name;
    private String password;
    private String balance_id;
}
