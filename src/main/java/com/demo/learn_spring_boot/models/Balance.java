package com.demo.learn_spring_boot.models;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Data
public class Balance {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    Integer id;

    Integer money;

    @OneToOne(mappedBy = "balance", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST, targetEntity = Users.class)
    private Users user;

}
