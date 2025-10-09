package com.ecommerce.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private int id;

    private String username;

    private  String password;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name= "user_role",joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "roles")
    @Enumerated(EnumType.STRING)
    private List<ROLES> roles;

    public enum ROLES{
        CUSTOMER,
        MANAGEMENT,
        SELLER,
        ADMIN
    }

}
