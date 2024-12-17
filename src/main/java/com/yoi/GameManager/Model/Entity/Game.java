package com.yoi.GameManager.Model.Entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "game")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "title",nullable = false)
    private String title;
    @Column(name = "developer")
    private String developer;
    @Column(name = "publisher")
    private String publisher;
    @JoinColumn(name = "owner")
    private Owner owner;
    private Date adquisitionDate;
}
