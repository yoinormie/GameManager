package com.yoi.GameManager.Model.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Date;

@Entity
@Table(name = "game")
@Document(collection = "Game")
@AllArgsConstructor
@NoArgsConstructor
@Data
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
