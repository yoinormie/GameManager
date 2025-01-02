package com.yoi.GameManager.Model.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Entity
@Table(name = "owner")
@Document(collection = "Owner")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Owner {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name",nullable = false)
    private String name;
    @Column(name = "first_surname", nullable = false)
    private String firstSurname;
    @Column(name = "second_surname")
    private String secondSurname;

}
