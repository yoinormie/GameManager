package com.yoi.GameManager.Model.Entity.JPA.GameManager;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "appuser")
@NoArgsConstructor
@Data
@ToString
@AllArgsConstructor
public class Appuser {
    @Id
    @Column(name = "id_user", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id_user;

    @Column(name = "username",nullable = false,length = 255)
    private String username;

    @Column(name = "email",nullable = false,unique = true)
    private String email;

    @Column(name = "password",nullable = false)
    private String password;

    @OneToMany(mappedBy = "userId", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<AccountHandler> handlerList;
    }
