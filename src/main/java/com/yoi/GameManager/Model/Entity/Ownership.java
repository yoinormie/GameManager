package com.yoi.GameManager.Model.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.UUID;

@Entity
@Table(name = "ownership")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Ownership {

    @Id
    @ManyToMany
    @JoinColumn(name = "id_owner", nullable = false)
    private UUID id_owner;

    @Id
    @ManyToMany
    @JoinColumn(name = "id_game", nullable = false)
    private UUID id_game;
}
