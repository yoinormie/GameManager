package com.yoi.GameManager.Model.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Entity
@Table(name = "game")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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
    @Column(name = "adquisitionDate")
    private Date adquisitionDate;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn (name = "owner")
    private Owner owner;
}
