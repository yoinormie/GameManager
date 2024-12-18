package com.yoi.GameManager.Model.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "owner")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Owner {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name",nullable = false)
    private String name;
    @Column(name = "first_surname")
    private String first_surname;
    @Column(name = "second_surname")
    private String second_surname;

}
