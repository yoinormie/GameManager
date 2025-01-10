package com.yoi.GameManager.Model.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "owner")
@Document(collection = "Owner")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Owner {
    @Id()
    private UUID UUID_owner;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "first_surname", nullable = false)
    private String firstSurname;

    @Column(name = "second_surname")
    private String secondSurname;

    @JoinColumn(name = "id_user", unique = true, nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private User userId;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ownership> ownershipList;
}
