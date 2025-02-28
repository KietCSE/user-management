package com.demo.learn_spring_boot.models;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Data
public class Users {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    Integer id;

    String name;

    String password;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST, targetEntity = Balance.class)
    @JoinColumn(name = "balance_id", referencedColumnName = "id", nullable = true)
    private Balance balance;
}
